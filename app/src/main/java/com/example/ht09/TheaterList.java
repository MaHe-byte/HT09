package com.example.ht09;

import android.view.View;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class TheaterList {

    private static TheaterList TL = new TheaterList();
    public static TheaterList getInstance(){
        return TL;
    }
    private int totaltht;;




    public void readXML(ArrayList<Theater> theaters) {
        DocumentBuilder builder;

        try {
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            String url = "https://www.finnkino.fi/xml/TheatreAreas/";
            Document doc = builder.parse(url);
            doc.getDocumentElement().normalize();
            System.out.println("Testi"+doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getDocumentElement().getElementsByTagName("TheatreArea");

            for (int i = 0; i < nList.getLength() ; i++ ){
                Node node =nList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    theaters.add(new Theater(element.getElementsByTagName("ID").item(0).getTextContent(),element.getElementsByTagName("Name").item(0).getTextContent()));
                    totaltht ++;
                }

            }


        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        finally {
            printTheathers(theaters);
        }


    }

    public void printTheathers(ArrayList<Theater> theaters) {
        for (int i = 0;i<totaltht;i++) {
            System.out.println((i+1)+". Name: "+theaters.get(i).getName());
            System.out.println("\tSize: "+theaters.get(i).getId());
        }
    }
}
