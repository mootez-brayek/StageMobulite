package Pi.Spring.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Pi.Spring.Entity.partenaires;
import Pi.Spring.Repositury.PartenaireRepository;



@Service
public class PartenaireService implements IPartenaireService{
	@Autowired
	PartenaireRepository partenaireRepository;

	@Override
	public List<partenaires> GetAllPartenaires() {
		// TODO Auto-generated method stub
		return  (List<partenaires>) partenaireRepository.findAll();
	}

	@Override
	public List<partenaires> GetAllByActivity(String activite) {
		// TODO Auto-generated method stub
		return  (List<partenaires>) partenaireRepository.findByActivite( activite);
	}
	
	public int CountEmails(String activite) {
		 List<partenaires> list = 	partenaireRepository.findByActivite( activite);
		return list.size();
	}

	@Override
	public partenaires AddPartenaire(partenaires partenaires) {
		// TODO Auto-generated method stub
		return partenaireRepository.save(partenaires);
	}
	

}
