package kodlamaio.hrms.business.concretes;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UsersServices;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccsess.abstracts.UsersDao;
import kodlamaio.hrms.entities.concretes.Users;

@Service
@RequiredArgsConstructor
public class UsersManager implements UsersServices{
	
	private final UsersDao usersDao;

	@Override
	public DataResult<List<Users>> getAll() {
		return new SuccessDataResult<List<Users>>
		(this.usersDao.findAll(),"Kullanıcılar Listelendi.");
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
		
		try {
			if(findByUsersEmail(users.getEmail()).getData()!=null &&findByUsersPassword(users.getPassword()).getData() != null) {
				return new SuccessDataResult<Users>("Giriş başarılı");
			}
			else {
				return new ErrorDataResult<Users>("Tekrar deneyiniz");
			}
			
		} catch (Exception e) {
			return new ErrorDataResult<Users>("Tekrar deneyiniz...");
		}
		
	}

	


}
