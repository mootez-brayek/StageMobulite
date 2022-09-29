package Pi.Spring.Repositury;


import javax.transaction.Transactional;


import org.springframework.data.repository.CrudRepository;


import Pi.Spring.Entity.Role;

public interface RoleRepository extends CrudRepository<Role,Long>{
	
	
	@Transactional
	public Role findByNomRole(String  nomRole);
	

	
}
