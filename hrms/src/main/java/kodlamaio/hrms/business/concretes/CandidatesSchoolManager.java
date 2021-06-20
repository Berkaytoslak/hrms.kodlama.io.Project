package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidatesSchoolServices;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccsess.abstracts.CandidatesSchoolDao;
import kodlamaio.hrms.entities.concretes.CandidatesSchool;
import kodlamaio.hrms.entities.dtos.CandidatesCvDtos;

@Service
public class CandidatesSchoolManager implements CandidatesSchoolServices{
	
	private CandidatesSchoolDao candidatesSchoolDao;
	
	
	@Autowired
	public CandidatesSchoolManager(CandidatesSchoolDao candidatesSchoolDao) {
		super();
		this.candidatesSchoolDao = candidatesSchoolDao;
	}

	@Override
	public DataResult<List<CandidatesSchool>> getAll() {
		return new SuccessDataResult<List<CandidatesSchool>>
		(this.candidatesSchoolDao.findAll(),"Okullar Listelendi");
	}

	@Override
	public Result add(CandidatesSchool candidatesSchool) {
		this.candidatesSchoolDao.save(candidatesSchool);
		return new SuccessResult("Tum bilgiler dogrulandi! Kayit basarili!");
	}

	@Override
	public DataResult<List<CandidatesCvDtos>> getCandidatesCvDtos() {
		return new SuccessDataResult<List<CandidatesCvDtos>>
		(this.candidatesSchoolDao.getCandidatesCvDtos(),"Özgeçmişlerin okul bilgileri listelendi");
	}

	@Override
	public DataResult<List<CandidatesCvDtos>> getCandidatesCvDtosEndedYearSort(String firstName) {
		return new SuccessDataResult<List<CandidatesCvDtos>>
		(this.candidatesSchoolDao.getCandidatesCvDtosEndedYearSort(firstName),"Kişiye Ait Özgeçmişler Listelendi");
	}

}
