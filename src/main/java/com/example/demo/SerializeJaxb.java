package com.example.demo;

import model.Cours;
import model.Matiere;
import model.Planning;
import model.Scheduled;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SerializeJaxb {
    public SerializeJaxb() {
    }

    public static void main(String[] args) throws JAXBException {
        ArrayList<Cours>cours=new ArrayList<>();
        cours.add(new Cours());
       createXmlByUsingObject(new Planning(), cours, new Cours(new Matiere(), new Scheduled()));


    }

    public static Planning readXml() throws Exception {

        File file=new File("C:\\Users\\kriss\\IdeaProjects\\demo\\src\\main\\resources\\testtest.xml");
        JAXBContext jaxbContext=JAXBContext.newInstance(Planning.class);
        Unmarshaller unmarshaller=jaxbContext.createUnmarshaller();
        Planning planning=(Planning) unmarshaller.unmarshal(file);
        System.out.println(planning.toString());
        return planning;
    }

    public static void createXmlByUsingObject(Planning planning, List<Cours> listCour, Cours cours) {
        try {
            if(planning==null){
                planning=new Planning();
            }
            if(listCour==null){
                listCour=new ArrayList<>();
            }

            listCour.add(cours);
            planning.setCours(listCour);
            JAXBContext jaxbContext1=JAXBContext.newInstance(Planning.class);
            Marshaller marshaller=jaxbContext1.createMarshaller();
            marshaller.marshal(planning, new File("C:\\Users\\kriss\\IdeaProjects\\demo\\src\\main\\resources\\testtest.xml"));
            marshaller.marshal(planning, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
