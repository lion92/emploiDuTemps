package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
// order of the fields in XML
// @XmlType(propOrder = {"price", "name"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Scheduled {
	public Scheduled() {
	}

	public Scheduled(double debut) {
		heureDebut = debut;
		
		heureFin = debut + dureeMinute / 60.0;
	}
	  @XmlElement
	public double heureDebut;
	  @XmlElement
	public double heureFin;
	  @XmlElement
	public double dureeMinute = 60.0;

	@Override
	public String toString() {
		return "Scheduled{" +
				"heureDebut=" + heureDebut +
				", heureFin=" + heureFin +
				", dureeMinute=" + dureeMinute +
				'}';
	}
}
