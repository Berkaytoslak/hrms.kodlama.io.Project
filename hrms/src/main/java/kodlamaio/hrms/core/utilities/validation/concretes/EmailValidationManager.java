package kodlamaio.hrms.core.utilities.validation.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.validation.abstracts.EmailValidationServices;

import kodlamaio.hrms.entities.concretes.Users;

@Service
public class EmailValidationManager implements EmailValidationServices{

	@Override
	public boolean sendMail(Users users) {

		return true;
	}

}
