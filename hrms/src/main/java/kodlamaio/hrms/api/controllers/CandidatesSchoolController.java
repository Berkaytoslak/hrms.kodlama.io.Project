package kodlamaio.hrms.api.controllers;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidatesSchoolServices;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidatesSchool;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/CandidatesSchoolCv")
public class CandidatesSchoolController {
	
	private final CandidatesSchoolServices candidatesSchoolServices;
	
	@GetMapping("/getAll/CandidatesSchoolCv")
	public DataResult<List<CandidatesSchool>> getAll(){
		return this.candidatesSchoolServices.getAll();
	}
	
	@PostMapping("/add/CandidatesSchoolCV")
	public Result add(@RequestBody CandidatesSchool candidatesSchool) {
		return this.candidatesSchoolServices.add(candidatesSchool);
	}

}
