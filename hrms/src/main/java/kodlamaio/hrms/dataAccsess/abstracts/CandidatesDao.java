package kodlamaio.hrms.dataAccsess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Candidates;

public interface CandidatesDao extends JpaRepository<Candidates, Integer>{
	Candidates findById(int id);
	Candidates findByEmail(String email); 
	Candidates findByIdentityNumber(String identityNumber);
}
