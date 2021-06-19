package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidatesExperienceServices;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccsess.abstracts.CandidatesExperienceDao;
import kodlamaio.hrms.entities.concretes.CandidatesExperience;

@Service
public class CandidatesExperienceManager implements CandidatesExperienceServices{
	
	private CandidatesExperienceDao candidatesExperienceDao;

	@Autowired
	public CandidatesExperienceManager(CandidatesExperienceDao candidatesExperienceDao) {
		super();
		this.candidatesExperienceDao = candidatesExperienceDao;
	}

	@Override
	public DataResult<List<CandidatesExperience>> getAll() {
		return new SuccessDataResult<List<CandidatesExperience>>
		(this.candidatesExperienceDao.findAll(),"Tecrübeler Listelendi");
	}

	@Override
	public Result add(CandidatesExperience candidatesExperience) {
		this.candidatesExperienceDao.save(candidatesExperience);
		return new SuccessResult("Tum bilgiler dogrulandi! Kayit basarili!");
	}

}
