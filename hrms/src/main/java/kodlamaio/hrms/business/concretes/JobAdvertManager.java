package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertServices;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccsess.abstracts.JobAdvertDao;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.EmployersWithJobAdverts;

@Service
public class JobAdvertManager implements JobAdvertServices{
	
	private JobAdvertDao jobAdvertDao;

	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao) {
		super();
		this.jobAdvertDao = jobAdvertDao;
	}

	@Override
	public DataResult<List<JobAdvert>> getAll() {
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.findAll(),"Tüm İş ilanları bilgileri Listelendi");
	}
	
	@Override
	public Result update(JobAdvert jobAdvert) {
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("Data Başarıyla Güncellendi");
	}

	@Override
	public DataResult<JobAdvert> getById(int id) {
		return new SuccessDataResult<JobAdvert>(this.jobAdvertDao.getOne(id));
	}

	@Override
	public Result changeActiveToDeactive(int id) {
		if(getById(id)==null) {
			return new ErrorResult("Gerekli kutuyu doldurun!");
		}
		if(getById(id).getData().isActive()==false) {
			return new ErrorResult("İş İlanı zaten aktif değil!");
		}
		JobAdvert jobAdvert=getById(id).getData();
		jobAdvert.setActive(false);
		update(jobAdvert);
		return new SuccessResult("İş İlanı devre dışı bırakıldı!");
	}
	
	public boolean isConfirmed(JobAdvert jobAdvert) {
		if (jobAdvert.getJobDescription() != null
				&& jobAdvert.getOpenPosition() != 0) {
			return true;
		} else
			return false;
	}

	public Result add(JobAdvert jobAdvert) {
		if (isConfirmed(jobAdvert)) {
			this.jobAdvertDao.save(jobAdvert);
			return new SuccessResult("İş İlanı başarıyla eklendi!");
		} else
			return new ErrorResult("Lütfen gerekli tüm kutuları doldurun!");
	}
	
	@Override
	public DataResult<List<JobAdvert>> getByActive() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByActiveTrue(),"Aktif iş ilanları listelendi!");
	}

	@Override
	public DataResult<List<EmployersWithJobAdverts>> getEmployersWithJobAdverts() {
		return new SuccessDataResult<List<EmployersWithJobAdverts>>
		(this.jobAdvertDao.getEmployersWithJobAdverts(),"Aktif iş ilanları Listelendi");
	}

	@Override
	public DataResult<List<EmployersWithJobAdverts>> getEmployersWithJobAdvertsSortDate() {
		return new SuccessDataResult<List<EmployersWithJobAdverts>>
		(this.jobAdvertDao.getEmployersWithJobAdvertsSortDate(),"İş ilanları tarihe göre Listelendi");
	}

	@Override
	public DataResult<List<EmployersWithJobAdverts>> getEmployersWithJobAdvertsDetails(String companyName) {
		return new SuccessDataResult<List<EmployersWithJobAdverts>>
		(this.jobAdvertDao.getEmployersWithJobAdvertsDetails(companyName),"Şirketin aktif ilanları Listelendi");
	}

	

}
