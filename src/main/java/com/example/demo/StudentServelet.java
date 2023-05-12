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
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@WebServlet("/StudentServlet")
public class StudentServelet extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IOException {

        String sheduled = req.getParameter("scheduled");
        String jour=req.getParameter("jour");
        String prof = req.getParameter("prof");
        String matiereProf = req.getParameter("matiereProf");
        Planning planning = SerializeJaxb.readXml();
        List<Cours> coursPrecedent = planning.getCours();
        //je trouve le plus grand id de la liste et je rajoute 1 pour créer un nouveau cour
        Collections.sort(coursPrecedent, Comparator.comparingInt(Cours::getId));
        SerializeJaxb.createXmlByUsingObject(planning, planning.getCours(), new Cours(coursPrecedent.get(0).getId() + 1, new Matiere(matiereProf, prof), new Scheduled(Double.parseDouble(sheduled),jour)));
        Planning planningResult = SerializeJaxb.readXml();
        AtomicReference<String> tdLundi= new AtomicReference<>("");
        AtomicReference<String> tdMardi= new AtomicReference<>("");
        AtomicReference<String> tdMercredi= new AtomicReference<>("");
        AtomicReference<String> tdJeudi= new AtomicReference<>("");
        AtomicReference<String> tdVendredi= new AtomicReference<>("");
        AtomicReference<String> tdSamedi= new AtomicReference<>("");
        AtomicReference<String> tdDimanche= new AtomicReference<>("");
        for(int debutCours=8; debutCours<18;debutCours++){

            int finalDebutCours = debutCours;
            planningResult.getCours()
                    .stream()
                    .filter(cours -> cours.getHoraire().getJour().equals("Lundi"))
                    .collect(Collectors.toList()).stream()
                    .filter(cours -> cours.getHoraire().getHeureDebut()== finalDebutCours).collect(Collectors.toList()).forEach(cours -> tdLundi.updateAndGet(v -> v + "<td>"+cours.getMatiere()+"</td>"));

            planningResult.getCours()
                    .stream()
                    .filter(cours -> cours.getHoraire().getJour().equals("Mardi"))
                    .collect(Collectors.toList()).stream()
                    .filter(cours -> cours.getHoraire().getHeureDebut()== finalDebutCours).collect(Collectors.toList()).forEach(cours -> tdMardi.updateAndGet(v -> v + "<td>"+cours.getMatiere()+"</td>"));


            planningResult.getCours()
                    .stream()
                    .filter(cours -> cours.getHoraire().getJour().equals("Mercrdi"))
                    .collect(Collectors.toList()).stream()
                    .filter(cours -> cours.getHoraire().getHeureDebut()== finalDebutCours).collect(Collectors.toList()).forEach(cours -> tdMercredi.updateAndGet(v -> v + "<td>"+cours.getMatiere()+"</td>"));

            planningResult.getCours()
                    .stream()
                    .filter(cours -> cours.getHoraire().getJour().equals("Jeudi"))
                    .collect(Collectors.toList()).stream()
                    .filter(cours -> cours.getHoraire().getHeureDebut()== finalDebutCours).collect(Collectors.toList()).forEach(cours -> tdJeudi.updateAndGet(v -> v + "<td>"+cours.getMatiere()+"</td>"));

            planningResult.getCours()
                    .stream()
                    .filter(cours -> cours.getHoraire().getJour().equals("Vendredi"))
                    .collect(Collectors.toList()).stream()
                    .filter(cours -> cours.getHoraire().getHeureDebut()== finalDebutCours).collect(Collectors.toList()).forEach(cours -> tdVendredi.updateAndGet(v -> v + "<td>"+cours.getMatiere()+"</td>"));
            planningResult.getCours()
                    .stream()
                    .filter(cours -> cours.getHoraire().getJour().equals("Samdedi"))
                    .collect(Collectors.toList()).stream()
                    .filter(cours -> cours.getHoraire().getHeureDebut()== finalDebutCours).collect(Collectors.toList()).forEach(cours -> tdSamedi.updateAndGet(v -> v + "<td>"+cours.getMatiere()+"</td>"));
            planningResult.getCours()
                    .stream()
                    .filter(cours -> cours.getHoraire().getJour().equals("Dimanche"))
                    .collect(Collectors.toList()).stream()
                    .filter(cours -> cours.getHoraire().getHeureDebut()== finalDebutCours).collect(Collectors.toList()).forEach(cours -> tdDimanche.updateAndGet(v -> v + "<td>"+cours.getMatiere()+"</td>"));


        }
        String jourlundi="";
        jourlundi+="<td>"+tdLundi+"</td>";

        String jourMardi="";
        jourMardi+="<td>"+tdMardi+"</td>";

        String jourMercredi="";
        jourMercredi+="<td>"+tdMercredi+"</td>";

        String jourJeudi="";
        jourJeudi+="<td>"+tdJeudi+"</td>";

        String jourVendredi="";
        jourVendredi+="<td>"+tdVendredi+"</td>";

        String jourSamedi="";
        jourSamedi+="<td>"+tdSamedi+"</td>";

        String jourDimanche="";
        jourDimanche+="<td>"+tdDimanche+"</td>";

        String strplannig="";
        strplannig+="<%@ page contentType=\"text/html; charset=UTF-8\" pageEncoding=\"UTF-8\" %>\n" +
                "<%@ page session=\"false\" %>\n" +
                "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <title>JSP - Hello World</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<h2>Emploi du temps</h2>\n" +
                "<h1><%= \"Hello World!\" %>\n" +
                "</h1>\n" +
                "<h1> Student Registration Page</h1>\n" +
                "<h1> Student Registration Page</h1>\n" +
                "<form action=\"<%= request.getContextPath() %>/StudentServlet\" method=\"post\">\n" +
                "\n" +
                "    Horraire: <input type=\"text\" name=\"scheduled\">\n" +
                "    <br> <br>\n" +
                "Professeur :<input type=\"text\" name=\"prof\">\n" +
                "    <br> <br>\n" +
                "\n" +
                "    Matiere: <input type=\"text\" name=\"matiereProf\">\n" +
                "    <br> <br>\n" +
                "\n" +
                "    jour: <input type=\"text\" name=\"jour\">\n" +
                "    <br> <br>\n" +
                "\n" +
                "    <input type=\"submit\" value=\"register\">\n" +
                "</form>\n" +
                "<br/>\n" +
                "<a href=\"hello-servlet\">Hello Servlet</a>\n" +
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
                "                <th> Heure </th>\n" +
                "                <th> Lundi </th>\n" +
                "                <th> Mardi </th>\n" +
                "                <th> Mercredi </th>\n" +
                "                <th> Jeudi </th>\n" +
                "                <th> Vendredi </th>\n" +
                "                <th> Samedi </th>\n" +
                "                <th> Dimanche </th>\n" +
                "            </tr>\n" +
                "            <tr>\n" +

                "                <td> 9h </td>\n" +

                "                <td class=\"français\"> Français </td>\n" +
                "                <td class=\"EPS\"> EPS </td>\n" +
                "                <td> Projet</td>\n" +
                "                <td> Géométrie </td>\n" +
                "                <td></td>\n" +
                "                <td></td>\n" +
                "                <td></td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td> 10h </td>\n" +
                "                <td> Math </td>\n" +
                "                <td> Français </td>\n" +
                "                <td>Projet</td>\n" +
                "                <td></td>\n" +
                "                <td></td>\n" +
                "                <td></td>\n" +
                "                <td></td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td> 11h </td>\n" +
                "                <td> Anglais </td>\n" +
                "                <td> Perm </td>\n" +
                "                <td>Projet</td>\n" +
                "                <td></td>\n" +
                "                <td></td>\n" +
                "                <td></td>\n" +
                "                <td></td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td> 12h </td>\n" +
                "                <td class=\"pause\"> Déjeuner </td>\n" +
                "                <td class=\"pause\"> Déjeuner </td>\n" +
                "                <td class=\"pause\">  </td>\n" +
                "                <td class=\"pause\"> Déjeuner </td>\n" +
                "                <td class=\"pause\"> Déjeuner </td>\n" +
                "                <td class=\"pause\"></td>\n" +
                "                <td class=\"pause\"></td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td> 14h </td>\n" +
                "                <td> Physique </td>\n" +
                "                <td> NSI </td>\n" +
                "                <td class=\"math\"> Algèbre </td>\n" +
                "                <td></td>\n" +
                "                <td></td>\n" +
                "                <td></td>\n" +
                "                <td></td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td> 16h </td>\n" +
                "                <td> Techno </td>\n" +
                "                <td> NSI </td>\n" +
                "                <td></td>\n" +
                "                <td></td>\n" +
                "                <td></td>\n" +
                "                <td></td>\n" +
                "                <td></td>\n" +
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


        PrintWriter printWriter= resp.getWriter();
        printWriter.print("</body>");
        printWriter.print("<a href='/demo'>retour<a/>");
        printWriter.print("<p>"+planningResult.toString()+"</p>");
        printWriter.print("</body>");
        printWriter.print("</html>");
        printWriter.close();

    }
}