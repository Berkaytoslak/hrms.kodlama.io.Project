package kodlamaio.hrms.dataAccsess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.CandidatesSchool;
import kodlamaio.hrms.entities.dtos.CandidatesCvDtos;

public interface CandidatesSchoolDao extends JpaRepository<CandidatesSchool, Integer>{
	@Query("Select new kodlamaio.hrms.entities.dtos.CandidatesCvDtos(cad.firstName,cad.lastName,sch.schoolName,dpr.departmentName,cads.startedYear,cads.endedYear) From CandidatesSchool cads Inner Join cads.candidates cad Inner Join cads.school sch Inner Join cads.department dpr")
	List<CandidatesCvDtos> getCandidatesCvDtos();
	
	@Query("Select new kodlamaio.hrms.entities.dtos.CandidatesCvDtos(cad.firstName,cad.lastName,sch.schoolName,dpr.departmentName,cads.startedYear,cads.endedYear) From CandidatesSchool cads Inner Join cads.candidates cad Inner Join cads.school sch Inner Join cads.department dpr Where cad.firstName=:firstName Order By cads.endedYear Desc")
	List<CandidatesCvDtos> getCandidatesCvDtosEndedYearSort(String firstName);
}
