package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobTittleServices;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobTittles;

@RestController
@RequestMapping("/api/JobTittles")
public class JobTittlesController {
	
	private JobTittleServices jobtittleServices;
	
	@Autowired
	public JobTittlesController (JobTittleServices jobtittleServices) {
		super();
		this.jobtittleServices = jobtittleServices;
	}
	
	@GetMapping("/Tittles")
	public DataResult<List<JobTittles>> getAll(){
		return this.jobtittleServices.getAll();
	}
	
	@PostMapping("/addTittles")
	public Result add(@RequestBody JobTittles jobTittles) {
		return this.jobtittleServices.add(jobTittles);
	}
	

}
