package kodlamaio.hrms.business.concretes;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidatesLinksServices;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccsess.abstracts.CandidatesLinksDao;
import kodlamaio.hrms.entities.concretes.CandidatesLinks;

@Service
@RequiredArgsConstructor
public class CandidatesLinksManager implements CandidatesLinksServices{
	
	private final CandidatesLinksDao candidatesLinksDao;

	@Override
	public DataResult<List<CandidatesLinks>> getAll() {
		return new SuccessDataResult<List<CandidatesLinks>>
		(this.candidatesLinksDao.findAll(),"Linkler Listelendi");
	}

	@Override
	public Result add(CandidatesLinks candidatesLinks) {
		this.candidatesLinksDao.save(candidatesLinks);
		return new SuccessResult("Tum bilgiler dogrulandi! Kayit basarili!");
	}

}
