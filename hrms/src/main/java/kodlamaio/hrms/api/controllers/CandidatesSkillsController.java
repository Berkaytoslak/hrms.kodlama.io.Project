package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidatesSkillsServices;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidatesSkills;

@RestController
@RequestMapping("/api/CandidatesSkillsCv")
public class CandidatesSkillsController {
	
	private CandidatesSkillsServices candidatesSkillsServices;

	@Autowired
	public CandidatesSkillsController(CandidatesSkillsServices candidatesSkillsServices) {
		super();
		this.candidatesSkillsServices = candidatesSkillsServices;
	}
	
	@GetMapping("/getAll/CandidatesSkillsCv")
	public DataResult<List<CandidatesSkills>> getAll(){
		return this.candidatesSkillsServices.getAll();
	}
	
	@PostMapping("/add/CandidatesSkillsCv")
	public Result add(@RequestBody CandidatesSkills candidatesSkills) {
		return this.candidatesSkillsServices.add(candidatesSkills);
	}

}
