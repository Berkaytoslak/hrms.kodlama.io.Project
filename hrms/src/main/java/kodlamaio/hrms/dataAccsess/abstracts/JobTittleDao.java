package kodlamaio.hrms.dataAccsess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobTittles;

public interface JobTittleDao extends JpaRepository<JobTittles, Integer>{
	JobTittles getByTittle(String tittle);
}
