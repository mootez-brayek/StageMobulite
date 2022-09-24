package Pi.Spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Pi.Spring.Entity.Condidat;
import Pi.Spring.Entity.Role;
import Pi.Spring.Repositury.CondidatRepository;
import Pi.Spring.Repositury.RoleRepository;

@Service
public class CondidatServiceImpl implements CondidatService {

	@Autowired
	CondidatRepository condidatRepo;
	@Autowired
	RoleRepository roleRepo;
	

	@Override
	public Condidat addCondidat(Condidat condidat) {
	
		condidatRepo.save(condidat);
		
		return condidat;
		
	}

	@Override
	public void deletCondidat(Long idCondidat) {
		Condidat condidat=condidatRepo.findById(idCondidat).orElse(null);
		
		condidatRepo.delete(condidat);
	}

	@Override
	public List<Condidat> retrieveAllCondidats() {
	
		return condidatRepo.findAll();
	}

	@Override
	public Condidat retrieveCondidat(Long idCondidat) {
		
		return condidatRepo.findById(idCondidat).orElse(null);
	}

	@Override
	public Condidat findBynom(String nom) {
		
		return condidatRepo.findByNom(nom);
	}

	@Override
	public Role saveRole(Role role) {
	
		return roleRepo.save(role);
	}

	@Override
	public void addRoleToUser(String nom, String nomRole) {
		Condidat condidat= condidatRepo.findByNom(nom);
		Role role = roleRepo.findByNomRole(nomRole);
		condidat.getRoles().add(role);
		
	}

	@Override
	public Role findBynomRole(String nomRole) {
	
		return roleRepo.findByNomRole(nomRole);
	}

}
