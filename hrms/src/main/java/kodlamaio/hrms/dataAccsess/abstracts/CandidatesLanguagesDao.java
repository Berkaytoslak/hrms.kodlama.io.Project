package kodlamaio.hrms.dataAccsess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidatesLanguages;

public interface CandidatesLanguagesDao extends JpaRepository<CandidatesLanguages, Integer>{

}
