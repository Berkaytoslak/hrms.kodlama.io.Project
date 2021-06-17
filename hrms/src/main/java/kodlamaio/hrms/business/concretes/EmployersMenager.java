package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployersServices;
import kodlamaio.hrms.core.adapter.EmailCheckServices;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.validation.abstracts.EmailValidationServices;
import kodlamaio.hrms.dataAccsess.abstracts.EmployersDao;
import kodlamaio.hrms.entities.concretes.Employers;

@Service
public class EmployersMenager implements EmployersServices{
	
	private EmployersDao employersDao;
	private EmailCheckServices emailCheckServices;
	private EmailValidationServices emailValidationServices;
	
	@Autowired
	public EmployersMenager(EmployersDao employersDao,EmailCheckServices emailCheckServices,EmailValidationServices emailValidationServices) {
		super();
		this.employersDao = employersDao;
		this.emailCheckServices = emailCheckServices;
		this.emailValidationServices = emailValidationServices;
	}

	@Override
	public DataResult<List<Employers>> getAll() {
		return new SuccessDataResult<List<Employers>>
		(this.employersDao.findAll(),"İşverenler Listelendi");
	}

	@Override
	public DataResult<Employers> getByEmail(String email) {
		return new SuccessDataResult<Employers>(this.employersDao.findByEmail(email));
	}

	@Override
	public Result add(Employers employers) {
		if(getByEmail(employers.getEmail()).getData()!=null){
			return new ErrorResult("Bu E-mail kullanılmaktadır.");
		}
		else if(!emailCheckServices.checkIfRealEmail(employers.getEmail())) {
			return new ErrorResult("Email formati dogrulanamadi!");
		}
		if (!employers.getPassword().equals(employers.getPasswordValidation())) {
			return new ErrorResult("Şifre tekrarı yanlış...");
		}
		else {
			if(emailValidationServices.sendMail(employers)) {
				this.employersDao.save(employers);
				return new SuccessResult("Tum bilgiler dogrulandi! Kayit basarili!");
			}else {
				return new ErrorResult("Eposta dogrulamasi gerceklestirilemedi! Kayit basarisiz! Tekrar deneyin!");
			}
		}
	}

}
