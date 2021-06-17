package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UsersServices;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccsess.abstracts.UsersDao;
import kodlamaio.hrms.entities.concretes.Users;

@Service
public class UsersManager implements UsersServices{
	
	private UsersDao usersDao;
	
	@Autowired
	public UsersManager(UsersDao usersDao) {
		super();
		this.usersDao = usersDao;
	}

	@Override
	public DataResult<List<Users>> getAll() {
		return new SuccessDataResult<List<Users>>
		(this.usersDao.findAll(),"Users Listelendi.");
	}

	@Override
	public DataResult<Users> findByUsersEmail(String email) {
		return new SuccessDataResult<Users>(this.usersDao.findByEmail(email));
	}

	@Override
	public DataResult<Users> findByUsersPassword(String password) {
		return new SuccessDataResult<Users>(this.usersDao.findByPassword(password));
	}

	@Override
	public DataResult<Users> Login(Users users) {
		if(findByUsersEmail(users.getEmail()).getData()!=null &&findByUsersPassword(users.getPassword()).getData() != null) {
			return new SuccessDataResult<Users>("Giriş başarılı");
		}
		else {
			return new ErrorDataResult<Users>("Tekrar deneyiniz");
		}
	}

	


}
