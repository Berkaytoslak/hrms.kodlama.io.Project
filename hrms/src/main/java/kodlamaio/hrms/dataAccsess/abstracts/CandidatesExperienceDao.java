package kodlamaio.hrms.dataAccsess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidatesExperience;

public interface CandidatesExperienceDao extends JpaRepository<CandidatesExperience, Integer>{

}
