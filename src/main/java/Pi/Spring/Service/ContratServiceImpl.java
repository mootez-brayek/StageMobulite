package Pi.Spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Pi.Spring.Entity.Condidat;
import Pi.Spring.Entity.Contrat;
import Pi.Spring.Entity.Logement;
import Pi.Spring.Repositury.CondidatRepository;
import Pi.Spring.Repositury.ContratRepository;
import Pi.Spring.Repositury.LogementRepository;

@Service
public class ContratServiceImpl implements ContratService{
	
	
	@Autowired
	ContratRepository contratRepo;
	
	@Autowired
	LogementRepository logementRepo;
	
	@Autowired
	CondidatRepository condidatRepo;
	
	public void addAndAffectContrat(Contrat contrat,Long idLogement,Long idCondidat){
		Logement logement=logementRepo.findById(idLogement).orElse(null);
		Condidat condidat= condidatRepo.findById(idCondidat).orElse(null);
		
		contrat.setCondidat(condidat);
		contrat.setLogement(logement);
		contrat.setCin(condidat.getCin());
		contrat.setNom(condidat.getNom());
		contrat.setPrenom(condidat.getPrenom());
		contrat.setAdresse(logement.getAdresse());
		contrat.setNbrChambre(logement.getNbrChambre());
		contrat.setType(logement.getType());
		contrat.setPrix(logement.getPrix());
	
		contratRepo.save(contrat);
		
		
	}


	@Override
	public void deletContrat(Long idContrat) {
		
		contratRepo.deleteById(idContrat);
	}

	@Override
	public List<Contrat> findAllContrats(Contrat contrat) {
		
		return contratRepo.retrieveAllContrats(contrat);
	}

	@Override
	public Contrat findLogement(Long idContrat) {
		
		return contratRepo.findById(idContrat).orElse(null);
	}

}
