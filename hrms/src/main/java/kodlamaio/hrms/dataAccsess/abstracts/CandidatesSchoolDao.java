package kodlamaio.hrms.dataAccsess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidatesSchool;

public interface CandidatesSchoolDao extends JpaRepository<CandidatesSchool, Integer>{
	
}
