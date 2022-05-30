package kodlamaio.hrms.api.controllers;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployersServices;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employers;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/Employers")
public class EmployersController {
	
	private final EmployersServices employersServices;
	
	@GetMapping("/find/Employers")
	public DataResult<List<Employers>> getAll(){
		return this.employersServices.getAll();
	}
	
	@PostMapping("/add/Employers")
	public Result add(@RequestBody Employers employers) {
		return this.employersServices.add(employers);
	}
	
	

}
