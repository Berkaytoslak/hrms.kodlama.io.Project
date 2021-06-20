package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidatesSchoolServices;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.dtos.CandidatesCvDtos;
import kodlamaio.hrms.entities.dtos.EmployersWithJobAdverts;

@RestController
@RequestMapping("/api/CandidatesCv")
public class CandidatesCVController {
	
private CandidatesSchoolServices candidatesSchoolServices;

	@Autowired
	public CandidatesCVController(CandidatesSchoolServices candidatesSchoolServices) {
		super();
		this.candidatesSchoolServices = candidatesSchoolServices;
	}
	
	@GetMapping("/get/CandidatesCvSchool")
	public DataResult<List<CandidatesCvDtos>> getCandidatesCvDtos(){
		return this.candidatesSchoolServices.getCandidatesCvDtos();
	}
	
	@GetMapping("/get/sort/CandidatesCvSchool")
	public DataResult<List<CandidatesCvDtos>> getCandidatesCvDtosEndedYearSort(@RequestParam("firstName") String firstName){
		return this.candidatesSchoolServices.getCandidatesCvDtosEndedYearSort(firstName);
	}	
	
	

}