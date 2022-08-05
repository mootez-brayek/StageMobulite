package Pi.Spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Pi.Spring.Entity.Condidat;
import Pi.Spring.Repositury.CondidatRepository;

@Service
public class CondidatServiceImpl implements CondidatService{
	
	@Autowired
	CondidatRepository condidatRepo;

	@Override
	public void addCondidat(Condidat condidat) {
		condidatRepo.save(condidat);
		
	}

	@Override
	public void deletCondidat(Long idCondidat) {
		Condidat condidat=condidatRepo.findById(idCondidat).orElse(null);
		
		condidatRepo.delete(condidat);
	}

	@Override
	public List<Condidat> retrieveAllCondidats(Condidat condidat) {
	
		return condidatRepo.retrieveAllCondidats(condidat);
	}

	@Override
	public Condidat retrieveCondidat(Long idCondidat) {
		
		return condidatRepo.findById(idCondidat).orElse(null);
	}

}
