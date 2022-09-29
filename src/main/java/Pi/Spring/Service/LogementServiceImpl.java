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
	public String addLogement(Logement logement) {
		logementRepo.save(logement);
		return null;
		
	}

	@Override
	public void deletLogement(Long IdLogement) {
		logementRepo.deleteById(IdLogement);
		
	}

	@Override
	public List<Logement> findAllLogement() {
		
		return logementRepo.findAll();
	}

	@Override
	public Logement findLogement(Long idLogement) {
		
		return logementRepo.findById(idLogement).orElse(null); 
	}

	@Override
	public Logement retrievePostById(Long idLogement) {
		
		return logementRepo.findById(idLogement).orElse(null);
	}



}
