package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.EmployersWithJobAdverts;

public interface JobAdvertServices {
	DataResult<List<JobAdvert>> getAll();
	Result update(JobAdvert jobAdvert);
	DataResult<JobAdvert> getById(int id);
	Result changeActiveToDeactive(int id);
	Result add(JobAdvert jobAdvert);
	DataResult<List<JobAdvert>> getByActive();
	DataResult<List<EmployersWithJobAdverts>> getEmployersWithJobAdverts();
	DataResult<List<EmployersWithJobAdverts>> getEmployersWithJobAdvertsSortDate();
	DataResult<List<EmployersWithJobAdverts>> getEmployersWithJobAdvertsDetails(String companyName);

}
