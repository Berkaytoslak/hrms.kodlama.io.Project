package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidatesLinksServices;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidatesLinks;

@RestController
@RequestMapping("/api/CandidatesLinksCv")
public class CandidatesLinksController {
	
	private CandidatesLinksServices candidatesLinksServices;

	@Autowired
	public CandidatesLinksController(CandidatesLinksServices candidatesLinksServices) {
		super();
		this.candidatesLinksServices = candidatesLinksServices;
	}
	
	@GetMapping("/getAll/CandidatesLinksCv")
	public DataResult<List<CandidatesLinks>> getAll(){
		return this.candidatesLinksServices.getAll();
	}
	
	@PostMapping("/add/CandidatesLinksCv")
	public Result add(@RequestBody CandidatesLinks candidatesLinks) {
		return this.candidatesLinksServices.add(candidatesLinks);
	}

}
