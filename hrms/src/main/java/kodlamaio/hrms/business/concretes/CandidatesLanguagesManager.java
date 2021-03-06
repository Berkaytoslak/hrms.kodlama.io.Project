package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidatesLanguagesServices;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccsess.abstracts.CandidatesLanguagesDao;
import kodlamaio.hrms.entities.concretes.CandidatesLanguages;

@Service
public class CandidatesLanguagesManager implements CandidatesLanguagesServices{
	
	private CandidatesLanguagesDao candidatesLanguagesDao;

	@Autowired
	public CandidatesLanguagesManager(CandidatesLanguagesDao candidatesLanguagesDao) {
		super();
		this.candidatesLanguagesDao = candidatesLanguagesDao;
	}

	@Override
	public DataResult<List<CandidatesLanguages>> getAll() {
		return new SuccessDataResult<List<CandidatesLanguages>>
		(this.candidatesLanguagesDao.findAll(),"Diller Listelendi");
	}

	@Override
	public Result add(CandidatesLanguages candidatesLanguages) {
		this.candidatesLanguagesDao.save(candidatesLanguages);
		return new SuccessResult("Tum bilgiler dogrulandi! Kayit basarili!");
	}


}
