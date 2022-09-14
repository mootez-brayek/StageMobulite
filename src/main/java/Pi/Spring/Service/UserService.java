package Pi.Spring.Service;

import java.util.List;

import Pi.Spring.Entity.User;
import Pi.Spring.Entity.Role;


public interface UserService {
	User addCondidat(User user);
	void deletCondidat(Long idCondidat);
	List<User> findUsers();
	User retrieveUser(Long idCondidat);
	User findBynom( String nom);
	Role findBynomRole( String nomRole);
	Role addRole(Role role);
	void addRoleToUser(String nom, String nomRole);
	

}
