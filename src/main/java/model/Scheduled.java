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
public class Scheduled {

    public Scheduled(double debut, String jour) {
        heureDebut = debut;

        heureFin = debut + dureeMinute / 60.0;
        this.jour = jour;
    }

    @XmlElement
    private String jour;
    @XmlElement
    public double heureDebut;
    @XmlElement
    public double heureFin;

    @XmlElement
    public double dureeMinute = 60.0;

    public Scheduled() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scheduled scheduled = (Scheduled) o;
        return Double.compare(scheduled.heureDebut, heureDebut) == 0 && Double.compare(scheduled.heureFin, heureFin) == 0 && Double.compare(scheduled.dureeMinute, dureeMinute) == 0 && Objects.equals(jour, scheduled.jour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(heureDebut, heureFin, jour, dureeMinute);
    }

    public double getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(double heureDebut) {
        this.heureDebut = heureDebut;
    }

    public double getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(double heureFin) {
        this.heureFin = heureFin;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public double getDureeMinute() {
        return dureeMinute;
    }

    public void setDureeMinute(double dureeMinute) {
        this.dureeMinute = dureeMinute;
    }

    @Override
    public String toString() {
        return "Scheduled{" +
                "jour='" + jour + '\'' +
                ", heureDebut=" + heureDebut +
                ", heureFin=" + heureFin +
                ", dureeMinute=" + dureeMinute +
                '}';
    }
}
