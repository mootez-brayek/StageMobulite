package Pi.Spring.Service;

import java.util.List;

import Pi.Spring.Entity.Condidat;
import Pi.Spring.Entity.Role;


public interface CondidatService {
	public Condidat addCondidat(Condidat condidat);
	public void deletCondidat(Long idCondidat);
	public List<Condidat> retrieveAllCondidats();
	public Condidat retrieveCondidat(Long idCondidat);
	public Condidat findBynom( String nom);
	public Role findBynomRole( String nomRole);
	public Role saveRole(Role role);

}
