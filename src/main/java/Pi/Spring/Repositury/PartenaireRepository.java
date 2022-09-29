package Pi.Spring.Repositury;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Pi.Spring.Entity.partenaires;

@Repository
public interface PartenaireRepository  extends JpaRepository<partenaires,Integer>{
	List<partenaires> findByActivite(String activite);

}
