/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegram_api;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author babar_muhammad_anas
 */
public class parseXml {
    
    Document document;
    String latitude,longitude;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String lat) {
        this.latitude = lat;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String lan) {
        this.longitude = lan;
    }

    public parseXml() {
    }
    
    
    public void parseDocument(String filename) throws ParserConfigurationException, SAXException, IOException {
        
        
        //
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Element root, element;
        NodeList nodeList;
        
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();

        document = builder.parse(filename);
        
        /*FileReader fr= new FileReader(filename);
        BufferedReader bf= new BufferedReader(fr);
        var v = bf.lines().collect(Collectors.joining("\n")); 
        System.out.println(v);*/
        
        
        //validator
        /*Schema schema = null;

        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory schemaFactory = SchemaFactory.newInstance(language);
        schema = schemaFactory.newSchema(new File(filename));

        Validator validator = schema.newValidator();
        validator.validate(new DOMSource(document));*/
        //
        root = document.getDocumentElement();
        nodeList = root.getElementsByTagName("place");
        //nodeList = document.getChildNodes();
        
        for (int temp = 0; temp < nodeList.getLength(); temp++) {
            Node node = nodeList.item(temp);
            System.out.println("");  
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                
                  System.out.println("lat: "    + eElement.getAttribute("lat"));
                  System.out.println("lon : "    + eElement.getAttribute("lon"));
                  //System.out.println("Data di nascita : "    + eElement.getElementsByTagName("Annodinascita").item(0).getTextContent());
                  //System.out.println("Nazionalita : "    + eElement.getElementsByTagName("Nazionalita").item(0).getTextContent());
                  /*dato = new Attori(eElement.getAttribute("currency"),Float.parseFloat(eElement.getAttribute("rate")));
                  listCurrency.add(dato);*/
                  latitude = eElement.getAttribute("lat");
                  longitude = eElement.getAttribute("lon");
                  
                  break;
            }
        }
}
    public Document getDocument() {
        return document;
    }
}
