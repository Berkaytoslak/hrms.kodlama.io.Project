package kodlamaio.hrms.business.concretes;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidatesExperienceServices;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccsess.abstracts.CandidatesExperienceDao;
import kodlamaio.hrms.entities.concretes.CandidatesExperience;
import kodlamaio.hrms.entities.dtos.CandidatesExperienceCvDtos;

@Service
@RequiredArgsConstructor
public class CandidatesExperienceManager implements CandidatesExperienceServices{
	
	private final CandidatesExperienceDao candidatesExperienceDao;

	@Override
	public DataResult<List<CandidatesExperience>> getAll() {
		return new SuccessDataResult<List<CandidatesExperience>>
		(this.candidatesExperienceDao.findAll(),"Tecrübeler Listelendi");
	}

	@Override
	public Result add(CandidatesExperience candidatesExperience) {
		this.candidatesExperienceDao.save(candidatesExperience);
		return new SuccessResult("Tum bilgiler dogrulandi! Kayit basarili!");
	}

	@Override
	public DataResult<List<CandidatesExperienceCvDtos>> getCandidatesExperienceCvDtos() {
		return new SuccessDataResult<List<CandidatesExperienceCvDtos>>
		(this.candidatesExperienceDao.getCandidatesExperienceCvDtos(),"Özgeçmişlerin tecrübe bilgileri listelendi");
	}

	@Override
	public DataResult<List<CandidatesExperienceCvDtos>> getCandidatesExperienceCvDtosLastDateSort(String firstName) {
		return new SuccessDataResult<List<CandidatesExperienceCvDtos>>
		(this.candidatesExperienceDao.getCandidatesExperienceCvDtosLastDateSort(firstName),"Kişiye Ait Özgeçmişler Listelendi");
	}

}
