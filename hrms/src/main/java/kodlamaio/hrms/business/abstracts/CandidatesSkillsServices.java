package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidatesSkills;

public interface CandidatesSkillsServices {
	
	DataResult<List<CandidatesSkills>> getAll();
	Result add(CandidatesSkills candidatesSkills);

}
