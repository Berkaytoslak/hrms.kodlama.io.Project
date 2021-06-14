package kodlamaio.hrms.dataAccsess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Users;

public interface UsersDao extends JpaRepository<Users,Integer>{
	Users getById(int id);
}
