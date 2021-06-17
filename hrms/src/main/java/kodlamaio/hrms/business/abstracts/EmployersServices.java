package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employers;

public interface EmployersServices {
	DataResult<List<Employers>> getAll();
	DataResult<Employers> getByEmail(String email);
	DataResult<Employers> getByPassword(String password);
	Result add(Employers employers);
}
