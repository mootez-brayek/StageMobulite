package Pi.Spring.Repositury;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import Pi.Spring.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByNom(String nom);

}
