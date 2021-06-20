package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidatesExperienceServices;
import kodlamaio.hrms.business.abstracts.CandidatesSchoolServices;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.dtos.CandidatesCvDtos;
import kodlamaio.hrms.entities.dtos.CandidatesExperienceCvDtos;

@RestController
@RequestMapping("/api/CandidatesCv")
public class CandidatesCVController {
	
private CandidatesSchoolServices candidatesSchoolServices;
private CandidatesExperienceServices candidatesExperienceServices;

	@Autowired
	public CandidatesCVController(CandidatesSchoolServices candidatesSchoolServices, CandidatesExperienceServices candidatesExperienceServices) {
		super();
		this.candidatesSchoolServices = candidatesSchoolServices;
		this.candidatesExperienceServices = candidatesExperienceServices;
	}
	
	@GetMapping("/get/CandidatesCvSchool")
	public DataResult<List<CandidatesCvDtos>> getCandidatesCvDtos(){
		return this.candidatesSchoolServices.getCandidatesCvDtos();
	}
	
	@GetMapping("/get/sort/CandidatesCvSchool")
	public DataResult<List<CandidatesCvDtos>> getCandidatesCvDtosEndedYearSort(@RequestParam("firstName") String firstName){
		return this.candidatesSchoolServices.getCandidatesCvDtosEndedYearSort(firstName);
	}	
	
	@GetMapping("/get/CandidatesCvExperiences")
	public DataResult<List<CandidatesExperienceCvDtos>> getCandidatesExperienceCvDtos(){
		return this.candidatesExperienceServices.getCandidatesExperienceCvDtos();
	}
	
	@GetMapping("/get/sort/CandidatesCvExperiences")
	public DataResult<List<CandidatesExperienceCvDtos>> getCandidatesExperienceCvDtosLastDateSort(@RequestParam("firstName") String firstName){
		return this.candidatesExperienceServices.getCandidatesExperienceCvDtosLastDateSort(firstName);
	}
	
	

}
