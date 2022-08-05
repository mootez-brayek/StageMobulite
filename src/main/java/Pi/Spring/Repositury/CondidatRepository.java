package Pi.Spring.Repositury;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import Pi.Spring.Entity.Condidat;

@Repository
public interface CondidatRepository extends CrudRepository<Condidat, Long> {
	@Query("SELECT c FROM Condidat c")
	@Transactional
	public List<Condidat> retrieveAllCondidats(Condidat condidat);

}
