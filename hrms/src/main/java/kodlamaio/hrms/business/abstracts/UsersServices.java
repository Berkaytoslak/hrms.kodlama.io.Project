package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Users;

public interface UsersServices {
	DataResult<List<Users>> getAll();
	DataResult<Users> findByUsersEmail(String email);
	DataResult<Users> findByUsersPassword(String password);
	DataResult<Users> Login(Users users);
}
