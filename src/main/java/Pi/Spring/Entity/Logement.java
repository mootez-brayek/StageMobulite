package Pi.Spring.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Logement implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idLogement;
	private int prix;
	private String adresse;
	private int nbrChambre;
	@Enumerated(EnumType.STRING)
	private Type type;
	private String dateDebut;
	private String image;

	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, mappedBy="logement")
	List<Contrat> contrats;


	public Long getIdLogement() {
		return idLogement;
	}


	public void setIdLogement(Long idLogement) {
		this.idLogement = idLogement;
	}


	public int getPrix() {
		return prix;
	}


	public void setPrix(int prix) {
		this.prix = prix;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public int getNbrChambre() {
		return nbrChambre;
	}


	public void setNbrChambre(int nbrChambre) {
		this.nbrChambre = nbrChambre;
	}


	public Type getType() {
		return type;
	}


	public void setType(Type type) {
		this.type = type;
	}







	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public List<Contrat> getContrats() {
		return contrats;
	}


	public void setContrats(List<Contrat> contrats) {
		this.contrats = contrats;
	}


	public String getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}
	
	
}
