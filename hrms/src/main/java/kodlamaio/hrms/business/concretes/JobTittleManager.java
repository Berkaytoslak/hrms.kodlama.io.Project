package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobTittleServices;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccsess.abstracts.JobTittleDao;
import kodlamaio.hrms.entities.concretes.JobTittles;
@Service
public class JobTittleManager implements JobTittleServices{

	private JobTittleDao jobTittleDao;
	
	@Autowired
	public JobTittleManager(JobTittleDao jobTittleDao) {
		super();
		this.jobTittleDao = jobTittleDao;
	}

	@Override
	public DataResult<List<JobTittles>> getAll(){
		return new SuccessDataResult<List<JobTittles>>
				(this.jobTittleDao.findAll(),"Başlıklar Listelendi");
				
	}

	@Override
	public Result add(JobTittles jobTittles) {
		if(getByTittle(jobTittles.getTittle()).getData() != null){
			return new ErrorResult("Bu pozisyon sistemde mevcut.");
		}
		this.jobTittleDao.save(jobTittles);
		return new SuccessResult("Başlık Eklendi");
	}

	@Override
	public DataResult<JobTittles>getByTittle(String tittle) {
		return new SuccessDataResult<JobTittles>(this.jobTittleDao.getByTittle(tittle));
	}

}
