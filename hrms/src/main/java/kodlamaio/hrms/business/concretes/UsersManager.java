package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UsersServices;
import kodlamaio.hrms.core.utilities.results.DataResult;
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
	public DataResult<Users> getById(int id) {
		return new SuccessDataResult<Users>(this.usersDao.getById(id));
	}

	

}
