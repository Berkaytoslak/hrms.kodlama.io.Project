package kodlamaio.hrms.dataAccsess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Employers;

public interface EmployersDao extends JpaRepository<Employers, Integer>{
	Employers findByEmail(String email); 
	Employers findByPassword(String password); 
}
