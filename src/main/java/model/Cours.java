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
public class Cours {
	public Cours() {
	}

	public Cours(Matiere math, Scheduled horraire) {
		matiere = math;
		horaire =horraire;
	}
	  @XmlElement
	private Matiere matiere;
	  @XmlElement
	private Scheduled horaire;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Cours cours = (Cours) o;
		return Objects.equals(matiere, cours.matiere) && Objects.equals(horaire, cours.horaire);
	}

	@Override
	public int hashCode() {
		return Objects.hash(matiere, horaire);
	}

	@Override
	public String toString() {
		return "Cours{" +
				"matiere=" + matiere.toString() +
				", horaire=" + horaire.toString() +
				'}';
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Scheduled getHoraire() {
		return horaire;
	}

	public void setHoraire(Scheduled horaire) {
		this.horaire = horaire;
	}
}
