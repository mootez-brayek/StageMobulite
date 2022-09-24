package Pi.Spring.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Contrat implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idContrat;
	
	private Long cin;
	private String adresse;
	private int nbrChambre;
	@Enumerated(EnumType.STRING)
	private Type type;
	private String nom;
	private String prenom;
	private float prix;
	private String debut;
	private int dure;
	
	
	@JsonIgnore
	@OneToOne
	 Condidat condidat;
	
	@JsonIgnore
	@ManyToOne
	Logement logement;


	public Long getIdContrat() {
		return idContrat;
	}


	public void setIdContrat(Long idContrat) {
		this.idContrat = idContrat;
	}


	public Long getCin() {
		return cin;
	}


	public void setCin(Long cin) {
		this.cin = cin;
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


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public float getPrix() {
		return prix;
	}


	public void setPrix(float prix) {
		this.prix = prix;
	}


	public String getDebut() {
		return debut;
	}


	public void setDebut(String debut) {
		this.debut = debut;
	}


	public int getDure() {
		return dure;
	}


	public void setDure(int dure) {
		this.dure = dure;
	}


	public Condidat getCondidat() {
		return condidat;
	}


	public void setCondidat(Condidat condidat) {
		this.condidat = condidat;
	}


	public Logement getLogement() {
		return logement;
	}


	public void setLogement(Logement logement) {
		this.logement = logement;
	}
	
	
}
