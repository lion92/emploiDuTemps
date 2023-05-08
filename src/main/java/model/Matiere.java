package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
// order of the fields in XML
// @XmlType(propOrder = {"price", "name"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Matiere {
	public Matiere() {
	}

	@XmlElement
	private String nomMatiere;
	  @XmlElement
	private String nomProfesseur;
	public Matiere(String _nomMatiere, String _nomProfesseur) {
		// TODO Auto-generated constructor stub
		nomMatiere = _nomMatiere;
		nomProfesseur = _nomProfesseur;
				
	}
	
	public String getNomMatiere() {
		return nomMatiere;
	}

	public void setNomMatiere(String nomMatiere) {
		this.nomMatiere = nomMatiere;
	}
	
	public String getNomProfesseur() {
		return nomProfesseur;
	}
	  
	public void setNomProfesseur(String nomProfesseur) {
		this.nomProfesseur = nomProfesseur;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Matiere matiere = (Matiere) o;
		return Objects.equals(nomMatiere, matiere.nomMatiere) && Objects.equals(nomProfesseur, matiere.nomProfesseur);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nomMatiere, nomProfesseur);
	}

	@Override
	public String toString() {
		return "Matiere{" +
				"nomMatiere='" + nomMatiere + '\'' +
				", nomProfesseur='" + nomProfesseur + '\'' +
				'}';
	}
}
