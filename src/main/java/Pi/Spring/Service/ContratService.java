package Pi.Spring.Service;

import java.util.List;

import Pi.Spring.Entity.Contrat;


public interface ContratService {
	public void addAndAffectContrat(Contrat contrat,Long idLogement,Long idCondidat);
	public void deletContrat(Long idContrat);
	public List<Contrat> findAllContrats(Contrat contrat);
	public Contrat findLogement(Long idContrat);
}
