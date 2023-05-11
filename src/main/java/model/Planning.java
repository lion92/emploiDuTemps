package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
// order of the fields in XML
// @XmlType(propOrder = {"price", "name"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Planning {

	
	public Planning() {
		ArrayList<Cours> lesCours = new ArrayList<Cours>();
	}
	
	public void addCoursInPlanning(Cours aCours) {
		lesCours.add(aCours);
	}

	@XmlElement
	private List<Cours> lesCours;

	public List<Cours> getCours() {
		return lesCours;
	}

	public void setCours(List<Cours> cours) {
		this.lesCours = cours;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Planning planning = (Planning) o;
		return Objects.equals(lesCours, planning.lesCours);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lesCours);
	}

	@Override
	public String toString() {
		return "Planning{" +
				"lesCours=" + lesCours +
				'}';
	}
}
