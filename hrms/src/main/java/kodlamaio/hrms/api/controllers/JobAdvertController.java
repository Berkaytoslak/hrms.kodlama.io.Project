package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertServices;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.EmployersWithJobAdverts;

@RestController
@RequestMapping("/api/JobTittles")
public class JobAdvertController {
	
	private JobAdvertServices jobAdvertServices;

	@Autowired
	public JobAdvertController(JobAdvertServices jobAdvertServices) {
		super();
		this.jobAdvertServices = jobAdvertServices;
	}
	
	@GetMapping("/getAll/JobAdvert")
	public DataResult<List<JobAdvert>> getAll(){
		return this.jobAdvertServices.getAll();
	}
	
	@PostMapping("/changeActiveToDeactive/JobAdvert")
	public Result changeActiveToDeactive(@RequestBody int id) {
		return this.jobAdvertServices.changeActiveToDeactive(id);

	}
	
	@PostMapping("/add/JobAdvert")
	public Result add(@RequestBody JobAdvert jobAdvert) {
		return this.jobAdvertServices.add(jobAdvert);
	}
	
	@GetMapping("/ActiveJob/JobAdvert")
	public DataResult<List<JobAdvert>> getAllActiveTrue() {
		return this.jobAdvertServices.getByActive();
	}
	
	@GetMapping("/getEmployersWithJobAdverts/Active")
	public DataResult<List<EmployersWithJobAdverts>> getEmployersWithJobAdverts(){
		return this.jobAdvertServices.getEmployersWithJobAdverts();
	}
	
	@GetMapping("/getEmployersWithJobAdvertsSortDate/Active")
	public DataResult<List<EmployersWithJobAdverts>> getEmployersWithJobAdvertsSortDate(){
		return this.jobAdvertServices.getEmployersWithJobAdvertsSortDate();
	}
	
	@GetMapping("/getEmployer/JobAdvert")
	public DataResult<List<EmployersWithJobAdverts>> getEmployersWithJobAdvertsDetails(@RequestParam("companyName") String companyName){
		return this.jobAdvertServices.getEmployersWithJobAdvertsDetails(companyName);
	}	

}
