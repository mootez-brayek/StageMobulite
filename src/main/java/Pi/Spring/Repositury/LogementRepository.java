package Pi.Spring.Repositury;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import Pi.Spring.Entity.Logement;


@Repository
public interface LogementRepository extends CrudRepository<Logement, Long>{
	
	@Query("SELECT l FROM Logement l")
	@Transactional
	public List<Logement> retrieveAllLogements(Logement logement);


}
