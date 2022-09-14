package Pi.Spring.Repositury;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Pi.Spring.Entity.Contrat;

@Repository
public interface ContratRepository extends JpaRepository<Contrat, Long>{

}
