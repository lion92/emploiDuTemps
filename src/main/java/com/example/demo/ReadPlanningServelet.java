package com.example.demo;

import lombok.SneakyThrows;
import model.Cours;
import model.Planning;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@WebServlet("/read")
public class ReadPlanningServelet extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IOException {
        Planning planning = SerializeJaxb.readXml();
        List<Cours> coursPrecedent = planning.getCours();
        //je trouve le plus grand id de la liste et je rajoute 1 pour créer un nouveau cour
        Collections.sort(coursPrecedent, Comparator.comparingInt(Cours::getId));
        UpdateServelet.ReadXml(resp, planning);

    }
}