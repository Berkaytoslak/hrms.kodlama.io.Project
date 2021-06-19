package kodlamaio.hrms.dataAccsess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidatesSkills;

public interface CandidatesSkillsDao extends JpaRepository<CandidatesSkills, Integer>{

}
