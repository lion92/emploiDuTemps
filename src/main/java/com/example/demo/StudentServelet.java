package com.example.demo;

import lombok.SneakyThrows;
import model.Cours;
import model.Matiere;
import model.Planning;
import model.Scheduled;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@WebServlet("/StudentServlet")
public class StudentServelet extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IOException {

        String sheduled = req.getParameter("scheduled");
        String jour = req.getParameter("jour");
        String prof = req.getParameter("prof");
        String matiereProf = req.getParameter("matiereProf");
        Planning planning = SerializeJaxb.readXml();
        List<Cours> coursPrecedent = planning.getCours();
        //je trouve le plus grand id de la liste et je rajoute 1 pour créer un nouveau cour
        Collections.sort(coursPrecedent, Comparator.comparingInt(Cours::getId));
        SerializeJaxb.createXmlByUsingObject(planning, planning.getCours(), new Cours(coursPrecedent.get(coursPrecedent.size() - 1).getId() + 1, new Matiere(matiereProf, prof), new Scheduled(Double.parseDouble(sheduled), jour)));
        Planning planningResult = SerializeJaxb.readXml();
        String tdLundi = "";
        String tdMardi = "";
        String tdMercredi = "";
        String tdJeudi = "";
        String tdVendredi = "";
        String tdSamedi = "";
        String tdDimanche = "";
        List<Cours> cours1 = planningResult.getCours();
        for (int debutCours = 8; debutCours < 18; debutCours++) {

            if (cours1 != null) {
                for (int cours = 0; cours < planning.getCours().size(); cours++) {
                    if (cours1.get(cours) != null) {
                        Cours coursIterationActuel = cours1.get(cours);
                        if ( coursIterationActuel.getHoraire()!= null) {
                        Scheduled horaireIterationActuelle = coursIterationActuel.getHoraire();
                        if( horaireIterationActuelle.getJour()!=null) {

                            String jourIterationActuel = horaireIterationActuelle.getJour();
                            if (jourIterationActuel.equals("Lundi")) {
                                if (horaireIterationActuelle.heureDebut == debutCours) {
                                    tdLundi +="<tr>" + "<td>"+"<span>" + debutCours + "</>"+coursIterationActuel.getMatiere() + "</td></tr>";
                                }
                            }
                            if (jourIterationActuel.equals("Mardi")) {
                                if (horaireIterationActuelle.heureDebut == debutCours) {
                                    tdLundi += "<tr>" +  "<td>"+"<span>" + debutCours + "</>"+coursIterationActuel.getMatiere() + "</td></tr>";
                                }
                            }
                            if (jourIterationActuel.equals("Mercredi")) {
                                if (horaireIterationActuelle.heureDebut == debutCours) {
                                    tdLundi += "<tr>" +  "<td>"+"<span>" + debutCours + "</>"+coursIterationActuel.getMatiere() + "</td></tr>";
                                }
                            }
                            if (jourIterationActuel.equals("Jeudi")) {
                                if (horaireIterationActuelle.heureDebut == debutCours) {
                                    tdLundi += "<tr>" +  "<td>"+"<span>" + debutCours + "</>"+coursIterationActuel.getMatiere() + "</td></tr>";
                                }
                            }
                            if (jourIterationActuel.equals("Vendredi")) {
                                if (horaireIterationActuelle.heureDebut == debutCours) {
                                    tdLundi += "<tr>" +  "<td>"+"<span>" + debutCours + "</>"+coursIterationActuel.getMatiere() + "</td></tr>";
                                }
                            }
                            if (jourIterationActuel.equals("Samedi")) {
                                if (horaireIterationActuelle.heureDebut == debutCours) {
                                    tdLundi += "<tr>" +  "<td>"+"<span>" + debutCours + "</>"+coursIterationActuel.getMatiere() + "</td></tr>";
                                }
                            }
                            if (jourIterationActuel.equals("Dimanche")) {
                                if (horaireIterationActuelle.heureDebut == debutCours) {
                                    tdLundi += "<tr>" +  "<td>"+"<span>" + debutCours + "</>"+coursIterationActuel.getMatiere() + "</td></tr>";
                                }
                            }

                        }
                        }
                    }

                }
            }


        }

        String strplannig = "";
        strplannig +=
                "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                        "<meta name=\"description\" content=\"Free Web tutorials\">\n" +
                        "<meta name=\"keywords\" content=\"HTML,CSS,XML,JavaScript\">"+
                "    <title>JSP - Hello World</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<a href=\"http://localhost:8081/demo\">retour au formulaire</a>."+
                "<div>\n" +
                "    <h2>Emploi du temps</h2>\n" +
                "\n" +
                "    <div id=\"m1\">\n" +
                "\n" +
                "        Voir les matières :\n" +
                "        <div>\n" +
                "            <em>ajouter le bouton eps ici</em>\n" +
                "            <input value='EPS' type=\"button\" onclick=showEPS\n" +
                "        </div>\n" +
                "        <div>\n" +
                "            <em>ajouter le bouton math ici</em>\n" +
                "        </div>\n" +
                "        <div>\n" +
                "            <em>ajouter le bouton projet ici</em>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "\n" +
                "    <div id=\"t1\">\n" +
                "        <table>\n" +
                "            <tr>\n" +
                "                <th> Lundi </th>\n" +
                "                <th> Mardi </th>\n" +
                "                <th> Mercredi </th>\n" +
                "                <th> Jeudi </th>\n" +
                "                <th> Vendredi </th>\n" +
                "                <th> Samedi </th>\n" +
                "                <th> Dimanche </th>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                tdLundi +
                tdMardi+
                tdMercredi+
                        tdJeudi+
                        tdVendredi+
                        tdSamedi+
                        tdDimanche+
                "            </tr>\n" +
                "        </table>\n" +
                "    </div>\n" +
                "    <style>\n" +
                "        body {\n" +
                "            background-color: Azure;\n" +
                "            font-family: sans-serif;\n" +
                "            font-size: 90%\n" +
                "        }\n" +
                "\n" +
                "        h2{\n" +
                "            color: DarkSlateGray;\n" +
                "        }\n" +
                "\n" +
                "        #m1, #t1 {\n" +
                "            display: inline-block;\n" +
                "            vertical-align: top;\n" +
                "        }\n" +
                "\n" +
                "        table{\n" +
                "            border-collapse: collapse;\n" +
                "        }\n" +
                "\n" +
                "        th, td {\n" +
                "            border: 1px solid Gray;\n" +
                "            padding: 7px;\n" +
                "            text-align: left;\n" +
                "        }\n" +
                "\n" +
                "        th {\n" +
                "            color: White;\n" +
                "            background-color: MediumSeaGreen;\n" +
                "        }\n" +
                "\n" +
                "        .pause {\n" +
                "            background-color: Wheat;\n" +
                "            font-style: italic;\n" +
                "        }\n" +
                "\n" +
                "\n" +
                "        tr th:first-child, tr td:first-child {\n" +
                "            background-color: SlateBlue;\n" +
                "            color: white;\n" +
                "            font-weight: bold;\n" +
                "            text-align: right;\n" +
                "        }\n" +
                "\n" +
                "        tr td:nth-last-child(2){\n" +
                "            background-color: LightSteelBlue;\n" +
                "        }\n" +
                "\n" +
                "        tr td:last-child{\n" +
                "            background-color: Silver;\n" +
                "        }\n" +
                "\n" +
                "        button{\n" +
                "            background-color: PaleTurquoise;\n" +
                "            border-radius: 5px;\n" +
                "            margin: 3px\n" +
                "        }\n" +
                "\n" +
                "        .français {\n" +
                "            background-color: silver;\n" +
                "        }\n" +
                "    </style>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>";


        PrintWriter printWriter = resp.getWriter();
        printWriter.print(strplannig);
        printWriter.close();

    }
}