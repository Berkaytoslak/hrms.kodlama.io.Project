package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidates;

public interface CandidatesServices {
	DataResult<List<Candidates>> getAll();
	DataResult<Candidates> getByEmail(String email);
	DataResult<Candidates> getByIdentityNumber(String identityNumber);
	DataResult<Candidates> getById(int id);
	Result add(Candidates candidates);
	
	
}
