package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidatesSchool;

public interface CandidatesSchoolServices {
	DataResult<List<CandidatesSchool>> getAll();
	Result add(CandidatesSchool candidatesSchool);
}
