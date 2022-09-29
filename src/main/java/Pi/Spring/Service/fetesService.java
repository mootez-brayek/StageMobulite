package Pi.Spring.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Pi.Spring.Entity.fetes;
import Pi.Spring.Repositury.fetesRepository;

@Service
public class fetesService implements IfetesService{
	
	@Autowired
	fetesRepository fetesRepository;

	@Override
	public List<fetes> GetAllfetes() {
		// TODO Auto-generated method stub
		return (List<fetes>) fetesRepository.findAll();
	}


	@Override
	public fetes Addfetes(fetes f) {
		// TODO Auto-generated method stub
		return fetesRepository.save(f);
	}




}
