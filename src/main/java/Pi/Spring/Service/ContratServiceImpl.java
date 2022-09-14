package Pi.Spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Pi.Spring.Entity.User;
import Pi.Spring.Entity.Contrat;
import Pi.Spring.Entity.Logement;
import Pi.Spring.Repositury.UserRepository;
import Pi.Spring.Repositury.ContratRepository;
import Pi.Spring.Repositury.LogementRepository;

@Service
public class ContratServiceImpl implements ContratService{
	
	
	@Autowired
	ContratRepository contratRepo;
	
	@Autowired
	LogementRepository logementRepo;
	
	@Autowired
	UserRepository condidatRepo;
	
	public void addAndAffectContrat(Contrat contrat,Long idLogement,Long idCondidat){
		Logement logement=logementRepo.findById(idLogement).orElse(null);
		User user= condidatRepo.findById(idCondidat).orElse(null);
		
		
		contrat.setLogement(logement);
		
		contrat.setNom(user.getNom());
		contrat.setPrenom(user.getPrenom());
		contrat.setAdresse(logement.getAdresse());
		contrat.setNbrChambre(logement.getNbrChambre());
		contrat.setType(logement.getType());
		contrat.setPrix(logement.getPrix());
		contrat.setDebut(logement.getDateDebut());
		contrat.setDure(logement.getDure());
		contratRepo.save(contrat);
		
		
	}


	@Override
	public void deletContrat(Long idContrat) {
		
		contratRepo.deleteById(idContrat);
	}

	@Override
	public List<Contrat> findAllContrats() {
		
		return contratRepo.findAll();
	}

	@Override
	public Contrat findLogement(Long idContrat) {
		
		return contratRepo.findById(idContrat).orElse(null);
	}

}
