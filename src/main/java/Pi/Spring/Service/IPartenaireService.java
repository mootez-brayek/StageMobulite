package Pi.Spring.Service;

import java.util.List;

import Pi.Spring.Entity.partenaires;



public interface IPartenaireService {
	public List<partenaires> GetAllPartenaires();
	public List<partenaires> GetAllByActivity(String activite);
	public partenaires AddPartenaire(partenaires partenaires);

}
