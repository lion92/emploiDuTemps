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

@WebServlet("/StudentServlet")
public class StudentServelet extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IOException {

        String sheduled = req.getParameter("scheduled");
        String prof = req.getParameter("prof");
        String matiereProf = req.getParameter("matiereProf");
        Planning planning=SerializeJaxb.readXml();

        SerializeJaxb.createXmlByUsingObject(planning, planning.getCours(), new Cours(new Matiere(matiereProf, prof), new Scheduled(Double.parseDouble(sheduled))));

        Planning planningApresAjout=SerializeJaxb.readXml();
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        printWriter.print("<html>");
        printWriter.print("<body>");
        printWriter.print("<h1>Emploi du temps actuelle</h1>");
        planningApresAjout.getCours().forEach(cours ->printWriter.print("<div><p>"+cours.getMatiere()+"<p/>"+"<p>"+cours.getHoraire()+"<p/></div>"));
        printWriter.print("</body>");
        printWriter.print("<a href='/demo'>retour<a/>");
        printWriter.print("</html>");
        printWriter.close();

    }
}