package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidatesSchool;
import kodlamaio.hrms.entities.dtos.CandidatesCvDtos;

public interface CandidatesSchoolServices {
	DataResult<List<CandidatesSchool>> getAll();
	Result add(CandidatesSchool candidatesSchool);
	DataResult<List<CandidatesCvDtos>> getCandidatesCvDtos();
	DataResult<List<CandidatesCvDtos>> getCandidatesCvDtosEndedYearSort(String firstName);
}
