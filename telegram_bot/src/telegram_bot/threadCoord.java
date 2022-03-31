/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegram_bot;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import telegram_api.*;

/**
 *
 * @author babar_muhammad_anas
 */
public class threadCoord extends Thread {
     HashMap<Integer,Integer> map;

    public threadCoord() {
         map = new HashMap<Integer,Integer>();
    }
     @Override
    public void run() {
        Functions func = new Functions();
        File f = new File("Coordinate.csv");
        Csv newCsv = new Csv();
         
        while(true){
            /*try {
             Vector<Csv> list = newCsv.readCsv();
         } catch (IOException ex) {
             Logger.getLogger(threadCoord.class.getName()).log(Level.SEVERE, null, ex);
         }*/
            Vector<Update> ArrayMsg = new Vector<>();
            ArrayMsg = func.getUpdates();
            for(Update msgs:ArrayMsg)
                    {
                        //System.out.println(msgs.ToString());
                       
                        Integer idChat = msgs.getMessage().getChat().getId();
                        String nome = msgs.getMessage().getChat().getFirst_name();
                        String coord = "";
                        Integer idUser = msgs.getMessage().getFrom().getId(); //id user
                        Integer idMess = msgs.getMessage().getMessage_id(); //id messaggio
                        if(!map.containsValue(idUser) || (map.containsValue(idUser) && idMess > map.get(idMess))) //se lo user non c'è o c'è e il messaggio è nuovo
                        {
                            map.put(idUser, idMess);
                                System.out.println(msgs.ToString());
                                String testo = msgs.getMessage().getText();
                        if(testo.contains("/citta") && testo.length() > 6){
                            try {
                                String citta = testo.substring(testo.indexOf(" "));
                                System.out.println(citta);
                                coord = func.getCoordinate(citta);
                                newCsv.checkUtente(idChat);
                                newCsv.toCsv(idChat,nome,coord);
                            } catch (IOException ex) {
                                Logger.getLogger(threadCoord.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (ParserConfigurationException ex) {
                                Logger.getLogger(threadCoord.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (SAXException ex) {
                                Logger.getLogger(threadCoord.class.getName()).log(Level.SEVERE, null, ex);
                            }
                             
                        }
                            
                        } 
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(threadCoord.class.getName()).log(Level.SEVERE, null, ex);
                }
                   }
        }
    
    
    
    
    
    }
    
     
     
}
