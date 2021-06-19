package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidatesLanguagesServices;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidatesLanguages;

@RestController
@RequestMapping("/api/CandidatesLanguagesCv")
public class CandidatesLanguagesController {
	
	private CandidatesLanguagesServices candidatesLanguagesServices;

	@Autowired
	public CandidatesLanguagesController(CandidatesLanguagesServices candidatesLanguagesServices) {
		super();
		this.candidatesLanguagesServices = candidatesLanguagesServices;
	}
	
	@GetMapping("/getAll/CandidatesLanguagesCv")
	public DataResult<List<CandidatesLanguages>> getAll(){
		return this.candidatesLanguagesServices.getAll();
	}
	
	@PostMapping("/add/CandidatesLanguagesCv")
	public Result add(@RequestBody CandidatesLanguages candidatesLanguages) {
		return this.candidatesLanguagesServices.add(candidatesLanguages);
	}

}
