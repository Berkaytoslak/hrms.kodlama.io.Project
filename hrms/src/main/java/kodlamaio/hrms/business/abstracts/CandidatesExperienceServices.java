package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidatesExperience;
import kodlamaio.hrms.entities.dtos.CandidatesExperienceCvDtos;

public interface CandidatesExperienceServices {
	DataResult<List<CandidatesExperience>> getAll();
	Result add(CandidatesExperience candidatesExperience);
	DataResult<List<CandidatesExperienceCvDtos>> getCandidatesExperienceCvDtos();
	DataResult<List<CandidatesExperienceCvDtos>> getCandidatesExperienceCvDtosLastDateSort(String firstName);
}
