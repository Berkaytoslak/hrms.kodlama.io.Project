package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidatesExperienceServices;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidatesExperience;

@RestController
@RequestMapping("/api/CandidatesExperienceCv")
public class CandidatesExperienceController {
	
	private CandidatesExperienceServices candidatesExperienceServices;

	@Autowired
	public CandidatesExperienceController(CandidatesExperienceServices candidatesExperienceServices) {
		super();
		this.candidatesExperienceServices = candidatesExperienceServices;
	}
	
	@GetMapping("/getAll/CandidatesExperienceCv")
	public DataResult<List<CandidatesExperience>> getAll(){
		return this.candidatesExperienceServices.getAll();
	}
	
	@PostMapping("/add/CandidatesExperienceCv")
	public Result add(@RequestBody CandidatesExperience candidatesExperience) {
		return this.candidatesExperienceServices.add(candidatesExperience);
	}

}
