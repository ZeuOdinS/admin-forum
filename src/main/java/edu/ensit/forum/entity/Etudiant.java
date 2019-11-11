package edu.ensit.forum.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ETU")
public class Etudiant extends Invite {
	
	private String prenom;
	private String ecole;
	private String specialite;
	private String classe;
	 
		




	public String getEcole() {
		return ecole;
	}

	public void setEcole(String ecole) {
		this.ecole = ecole;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	

}
