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
        SerializeJaxb.createXmlByUsingObject(planning, planning.getCours(),
                new Cours(coursPrecedent.get(coursPrecedent.size() - 1).getId() + 1,
                        new Matiere(matiereProf, prof),
                        new Scheduled(Double.parseDouble(sheduled), jour)));
        UpdateServelet.ReadXml(resp, planning);

    }
}