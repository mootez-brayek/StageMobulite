package Pi.Spring.Service;

import java.util.List;

import Pi.Spring.Entity.Logement;

public interface LogementService {
	
	
public String addLogement(Logement logement);
public void deletLogement(Long IdLogement);
public List<Logement> findAllLogement();
public Logement findLogement(Long idLogement);
public Logement retrievePostById(Long idLogement);

}
