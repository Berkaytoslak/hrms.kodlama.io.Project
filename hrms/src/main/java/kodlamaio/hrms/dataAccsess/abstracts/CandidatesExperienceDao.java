package kodlamaio.hrms.dataAccsess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.CandidatesExperience;
import kodlamaio.hrms.entities.dtos.CandidatesExperienceCvDtos;

public interface CandidatesExperienceDao extends JpaRepository<CandidatesExperience, Integer>{
	@Query("Select new kodlamaio.hrms.entities.dtos.CandidatesExperienceCvDtos(cad.firstName,cad.lastName,exr.companyName,pst.positionName,cex.startDate,cex.lastDate) From CandidatesExperience cex Inner Join cex.candidates cad Inner Join cex.experiences exr Inner Join cex.position pst")
	List<CandidatesExperienceCvDtos> getCandidatesExperienceCvDtos();
	
	@Query("Select new kodlamaio.hrms.entities.dtos.CandidatesExperienceCvDtos(cad.firstName,cad.lastName,exr.companyName,pst.positionName,cex.startDate,cex.lastDate) From CandidatesExperience cex Inner Join cex.candidates cad Inner Join cex.experiences exr Inner Join cex.position pst Where cad.firstName=:firstName Order By cex.lastDate Desc")
	List<CandidatesExperienceCvDtos> getCandidatesExperienceCvDtosLastDateSort(String firstName);
}
