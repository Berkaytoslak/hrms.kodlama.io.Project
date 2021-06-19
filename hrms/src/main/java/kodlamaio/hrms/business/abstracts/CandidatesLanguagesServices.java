package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidatesLanguages;

public interface CandidatesLanguagesServices{
	DataResult<List<CandidatesLanguages>> getAll();
	Result add(CandidatesLanguages candidatesLanguages);

}
