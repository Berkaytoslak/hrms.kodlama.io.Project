package kodlamaio.hrms.dataAccsess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.EmployersWithJobAdverts;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer>{
	@Query("From JobAdvert where isActive=true")
	List<JobAdvert> getByActiveTrue();
	
	@Query("Select new kodlamaio.hrms.entities.dtos.EmployersWithJobAdverts(emp.companyName,jb.jobDescription,jb.openPosition,jb.activeDate,jb.lastDate) From JobAdvert jb Inner Join jb.employers emp Where jb.isActive = true")
	List<EmployersWithJobAdverts> getEmployersWithJobAdverts();
	
	@Query("Select new kodlamaio.hrms.entities.dtos.EmployersWithJobAdverts(emp.companyName,jb.jobDescription,jb.openPosition,jb.activeDate,jb.lastDate) From JobAdvert jb Inner Join jb.employers emp Where jb.isActive = true Order By jb.activeDate Desc")
	List<EmployersWithJobAdverts> getEmployersWithJobAdvertsSortDate();
	
	/*@Query("Select new kodlamaio.hrms.entities.dtos.EmployersWithJobAdverts(emp.companyName,jb.jobDescription,jb.openPosition,jb.activeDate,jb.lastDate) From JobAdvert jb Inner Join jb.employers emp Where jb.isActive = true")
	List<EmployersWithJobAdverts> getEmployersWithJobAdvertsDetails();*/
}
