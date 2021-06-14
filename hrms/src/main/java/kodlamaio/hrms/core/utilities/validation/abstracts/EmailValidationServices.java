package kodlamaio.hrms.core.utilities.validation.abstracts;

import kodlamaio.hrms.entities.concretes.Users;

public interface EmailValidationServices {
	public boolean sendMail(Users users);
}
