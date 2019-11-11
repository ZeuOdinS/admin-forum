package edu.ensit.forum.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ENT")
public class Entreprise extends Invite {

	private String raisonSociale;
	private String adresse;
	private String domaineActivites;






	

	public String getRaisonSociale() {
		return raisonSociale;
	}

	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getDomaineActivites() {
		return domaineActivites;
	}

	public void setDomaineActivites(String domaineActivites) {
		this.domaineActivites = domaineActivites;
	}
	
	

	
	
}
