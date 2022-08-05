package Pi.Spring.Service;

import java.util.List;

import Pi.Spring.Entity.Condidat;


public interface CondidatService {
	public void addCondidat(Condidat condidat);
	public void deletCondidat(Long idCondidat);
	public List<Condidat> retrieveAllCondidats(Condidat condidat);
	public Condidat retrieveCondidat(Long idCondidat);

}
