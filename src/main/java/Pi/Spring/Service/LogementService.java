package Pi.Spring.Service;

import java.util.List;

import Pi.Spring.Entity.Logement;

public interface LogementService {
	
	
public void addLogement(Logement logement);
public void deletLogement(Long IdLogement);
public List<Logement> findAllLogement(Logement logement);
public Logement findLogement(Long idLogement);

}
