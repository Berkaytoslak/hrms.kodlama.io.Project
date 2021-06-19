package kodlamaio.hrms.dataAccsess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidatesLinks;

public interface CandidatesLinksDao extends JpaRepository<CandidatesLinks, Integer>{

}
