package Pi.Spring.Repositury;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;



import Pi.Spring.Entity.Role;

public interface RoleRepository extends JpaRepository<Role,Long>{
	
	

	Role findByNomRole(String nomRole);
	

	
}
