package Pi.Spring.Repositury;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import Pi.Spring.Entity.Condidat;

@Repository
public interface CondidatRepository extends JpaRepository<Condidat, Long> {

	public Condidat findByNom(String  nom);
	
	


}
