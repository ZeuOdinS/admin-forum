package edu.ensit.forum.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("EMP")
public class Employe extends Invite {

	private String prenom;
	private String fonction;
	private String entreprise;
	
	
	

	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getFonction() {
		return fonction;
	}
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	public String getEntreprise() {
		return entreprise;
	}
	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}
	
	
	
}
