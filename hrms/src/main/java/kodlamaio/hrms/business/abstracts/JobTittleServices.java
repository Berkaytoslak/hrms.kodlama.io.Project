package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobTittles;

public interface JobTittleServices {
	DataResult<List<JobTittles>> getAll();
	Result add(JobTittles jobTittles);
	DataResult<JobTittles>getByTittle(String tittle);
}
