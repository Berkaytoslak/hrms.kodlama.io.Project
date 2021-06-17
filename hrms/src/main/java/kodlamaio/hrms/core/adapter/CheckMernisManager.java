package kodlamaio.hrms.core.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.dataAccsess.abstracts.CandidatesDao;
import kodlamaio.hrms.entities.concretes.Candidates;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;
@Service

public class CheckMernisManager implements CheckMernisServices{
	
	private CandidatesDao candidatesDao;
	
	@Autowired
	public CheckMernisManager(CandidatesDao candidatesDao) {
		super();
		this.candidatesDao = candidatesDao;
		
	}

	@Override
	public boolean checkIfRealTcNo(Candidates candidates) {
		candidates = this.candidatesDao.findById(candidates.getId());
		if (candidates == null) {
			return false;
		}
		
		
		KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();

        boolean serviceResult=false;

        try {

            serviceResult = kpsPublicSoapProxy.TCKimlikNoDogrula(
            		Long.parseLong(candidates.getIdentityNumber()),
                    candidates.getFirstName().toUpperCase(),
                    candidates.getLastName().toUpperCase(),
                    candidates.getBirthYear());
           

        } catch (Exception e) {

            System.out.println("Geçerli bir kişi değil");
            
        }
        return serviceResult;
        
	}

}
