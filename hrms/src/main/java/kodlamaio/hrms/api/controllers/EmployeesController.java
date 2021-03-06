package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployeesServices;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Employees;

@RestController
@RequestMapping("/api/Employees")
public class EmployeesController {
	
	private EmployeesServices employeesServices;
	
	@Autowired
	public EmployeesController(EmployeesServices employeesServices) {
		super();
		this.employeesServices = employeesServices;
	}
	
	@GetMapping("/getAll/Employees")
	public DataResult<List<Employees>> getAll(){
		return this.employeesServices.getAll();
	}
	
	

}
