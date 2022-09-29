package Pi.Spring.Repositury;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Pi.Spring.Entity.fetes;



@Repository
public interface fetesRepository  extends JpaRepository<fetes,Integer>{
	

}
