package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidatesServices;
import kodlamaio.hrms.core.adapter.CheckMernisServices;
import kodlamaio.hrms.core.adapter.EmailCheckServices;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.validation.abstracts.EmailValidationServices;
import kodlamaio.hrms.dataAccsess.abstracts.CandidatesDao;
import kodlamaio.hrms.entities.concretes.Candidates;

@Service
public class CandidatesManager implements CandidatesServices{
	
	private CheckMernisServices checkMernisServices;
	private CandidatesDao candidatesDao;
	private EmailCheckServices emailCheckServices;
	private EmailValidationServices emailValidationServices;
	
	
	@Autowired
	public CandidatesManager(CandidatesDao candidatesDao, CheckMernisServices checkMernisServices,EmailCheckServices emailCheckServices,EmailValidationServices emailValidationServices) {
		super();
		this.candidatesDao = candidatesDao;
		this.checkMernisServices = checkMernisServices;
		this.emailCheckServices = emailCheckServices;
		this.emailValidationServices = emailValidationServices;
		
	}
	private boolean validationForCandidate(Candidates candidate) {
		if (Objects.isNull(candidate.getIdentityNumber()) 
				|| Objects.isNull(candidate.getFirstName()) 
				|| Objects.isNull(candidate.getLastName()) 
				|| Objects.isNull(candidate.getEmail()) 
				|| Objects.isNull(candidate.getPassword()) 
				|| Objects.isNull(candidate.getBirthYear())) {
			return false;
		}
		else {
			return true;
		}
	  
	}

	@Override
	public DataResult<List<Candidates>> getAll() {
		return new SuccessDataResult<List<Candidates>>
		(this.candidatesDao.findAll(),"İş arayanlar Listelendi");
	}
	
	@Override
	public DataResult<Candidates> getByEmail(String email) {
		return new SuccessDataResult<Candidates>(this.candidatesDao.findByEmail(email));
	}
	
	@Override
	public DataResult<Candidates> getByPassword(String password) {
		return new SuccessDataResult<Candidates>(this.candidatesDao.findByPassword(password));
	}

	@Override
	public DataResult<Candidates> getByIdentityNumber(String identityNumber) {
		return new SuccessDataResult<Candidates>(this.candidatesDao.findByIdentityNumber(identityNumber));
	}
	
	@Override
	public DataResult<Candidates> getById(int id) {
		return new SuccessDataResult<Candidates>(this.candidatesDao.findById(id));
	}

	@Override
	public Result add(Candidates candidates) {
		if(checkMernisServices.checkIfRealTcNo(candidates)==false){
			return new ErrorResult("Geçerli Kişi Gir");
		}
		else if(!validationForCandidate(candidates)) {
			return new ErrorResult("Eksik bilgi girdiniz. Lütfen bilgilerinizi tekrar kontrol ediniz.");
		}
		else if(getByEmail(candidates.getEmail()).getData()!=null){
			return new ErrorResult("Bu E-mail kullanılmaktadır.");
		}
		else if(getByPassword(candidates.getPassword()).getData()!=null){
			return new ErrorResult("Bu password kullanılmaktadır.");
		}
		else if(getByIdentityNumber(candidates.getIdentityNumber()).getData()!=null){
			return new ErrorResult("Bu TC kullanılmaktadır.");
		}
		else if(!emailCheckServices.checkIfRealEmail(candidates.getEmail())) {
			return new ErrorResult("Email formati dogrulanamadi!");
		}
		else if (!candidates.getPassword().equals(candidates.getPasswordValidation())) {
			return new ErrorResult("Şifre tekrarı yanlış...");
		}
		else {
			if(emailValidationServices.sendMail(candidates)) {
				this.candidatesDao.save(candidates);
				return new SuccessResult("Tum bilgiler dogrulandi! Kayit basarili!");
			}else {
				return new ErrorResult("Eposta dogrulamasi gerceklestirilemedi! Kayit basarisiz! Tekrar deneyin!");
			}
		}
		
	}
	
	

}
