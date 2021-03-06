package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CitiesServices;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Cities;

@RestController
@RequestMapping("/api/Cities")
public class CitiesController {
	
	private CitiesServices citiesServices;
	
	@Autowired
	public CitiesController(CitiesServices citiesServices) {
		super();
		this.citiesServices = citiesServices;
	}
	
	@GetMapping("/getAll/Cities")
	public DataResult<List<Cities>> getAll(){
		return this.citiesServices.getAll();
	}
	
	
}
