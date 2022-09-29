package Pi.Spring.Entity;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collection;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Condidat implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCondidat;
	
	private Long cin;
	private int age;

	private String email;
	private Long telephone;
	private String nom;
	private String prenom;
	
	
	
	
	
	@JsonIgnore
	@OneToOne(cascade=CascadeType.ALL,mappedBy="condidat")
	 Contrat contrat;


	public Long getIdCondidat() {
		return idCondidat;
	}


	public void setIdCondidat(Long idCondidat) {
		this.idCondidat = idCondidat;
	}


	public Long getCin() {
		return cin;
	}


	public void setCin(Long cin) {
		this.cin = cin;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Long getTelephone() {
		return telephone;
	}


	public void setTelephone(Long telephone) {
		this.telephone = telephone;
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


	public Contrat getContrat() {
		return contrat;
	}


	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}







	public Condidat(Long idCondidat, Long cin, int age, String email, Long telephone, String nom, String prenom,
			String password, String picture) {
		super();
		this.idCondidat = idCondidat;
		this.cin = cin;
		this.age = age;
		this.email = email;
		this.telephone = telephone;
		this.nom = nom;
		this.prenom = prenom;
	
	}

	
	
	
	
	
	
	
}
