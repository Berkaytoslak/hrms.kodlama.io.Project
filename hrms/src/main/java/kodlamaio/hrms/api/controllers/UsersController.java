package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.UsersServices;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Users;

@RestController
@RequestMapping("/api/Users")
public class UsersController {
	
	private UsersServices usersServices;
	
	@Autowired
	public UsersController(UsersServices usersServices) {
		super();
		this.usersServices = usersServices;
	}
	
	@GetMapping("/getAll/Users")
	public DataResult<List<Users>> getAll(){
		return this.usersServices.getAll();
	}
	
	@PostMapping("/Login/Users")
	public Result Login(@RequestBody Users users) {
		return this.usersServices.Login(users);
	}
	
	
	

}
