package Pi.Spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Pi.Spring.Entity.Logement;
import Pi.Spring.Repositury.LogementRepository;

@Service
public class LogementServiceImpl implements LogementService{
	
	
	@Autowired
	LogementRepository logementRepo;
	
	
	

	@Override
	public void addLogement(Logement logement) {
		logementRepo.save(logement);
		
	}

	@Override
	public void deletLogement(Long IdLogement) {
		logementRepo.deleteById(IdLogement);
		
	}

	@Override
	public List<Logement> findAllLogement(Logement logement) {
		
		return logementRepo.retrieveAllLogements(logement);
	}

	@Override
	public Logement findLogement(Long idLogement) {
		
		return logementRepo.findById(idLogement).orElse(null); 
	}

}
