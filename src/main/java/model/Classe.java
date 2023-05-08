package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
// order of the fields in XML
// @XmlType(propOrder = {"price", "name"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Classe {

	public Classe(String nomclass) {
		nomClasse =nomclass;
		if(planning==null)
			planning = new Planning();
	}
	  @XmlElement(name="nomClasse")
	private String nomClasse;
	  @XmlElement(name="classPlanning")
	private Planning planning;

	@Override
	public String toString() {
		return "Classe{" +
				"nomClasse='" + nomClasse + '\'' +
				", planning=" + planning +
				'}';
	}

	/***
	 * J'ajoute un cours a mon planning
	 * @param aCours
	 */
	public void addCoursDansMonPlanning(Cours aCours) {
		planning.getCours().add(aCours);
	}
}
