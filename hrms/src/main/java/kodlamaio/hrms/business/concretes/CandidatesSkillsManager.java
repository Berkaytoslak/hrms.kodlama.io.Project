package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidatesSkillsServices;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccsess.abstracts.CandidatesSkillsDao;
import kodlamaio.hrms.entities.concretes.CandidatesSkills;

@Service
public class CandidatesSkillsManager implements CandidatesSkillsServices{
	
	private CandidatesSkillsDao candidatesSkillsDao;

	@Autowired
	public CandidatesSkillsManager(CandidatesSkillsDao candidatesSkillsDao) {
		super();
		this.candidatesSkillsDao = candidatesSkillsDao;
	}

	@Override
	public DataResult<List<CandidatesSkills>> getAll() {
		return new SuccessDataResult<List<CandidatesSkills>>
		(this.candidatesSkillsDao.findAll(),"Yetenekler Listelendi");
	}

	@Override
	public Result add(CandidatesSkills candidatesSkills) {
		this.candidatesSkillsDao.save(candidatesSkills);
		return new SuccessResult("Tum bilgiler dogrulandi! Kayit basarili!");
	}

}
