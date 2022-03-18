/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegram_api;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

/**
 *
 * @author babar
 */
public class Csv {
    
    int id_chat;
    String nome;
    String lat, lon;
    

    public Csv() {
    }

    public Csv(int id_chat, String nome, String lat, String lon) {
        this.id_chat = id_chat;
        this.nome = nome;
        this.lat = lat;
        this.lon = lon;
    }

    

    

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId_chat() {
        return id_chat;
    }

    public void setId_chat(int id_chat) {
        this.id_chat = id_chat;
    }
    
    public void toCsv(int id_chat, String nome, String coordinate, boolean method) throws FileNotFoundException{
        //String s = "";
        
        
        
        PrintWriter pw = new PrintWriter(new FileOutputStream(  new File("Coordinate.csv"), method /* append = true */)); 
        
        StringBuilder builder = new StringBuilder();
       // String columnNamesList = "id_chat,nome,lat,lon";
        // No need give the headers Like: id, Name on builder.append
        //builder.append(columnNamesList +"\n");
        builder.append(String.valueOf(id_chat) + ",");
        builder.append(nome + ",");
        builder.append(coordinate);
        builder.append('\n');
        pw.append(builder.toString());
        pw.close();
        pw.flush();
        System.out.println("done!");
        //s = String.valueOf(id_chat) + ";" + nome + ";" + lat + ";" + lon + "\n"; 
        
        //return s;
    }
    public boolean checkUtente(String nome) throws FileNotFoundException, IOException{
        boolean ok = false;
        Vector<Csv> ArrCsv= readCsv(); 
         for(Csv msg: ArrCsv){
         if(msg.nome == nome){
             ok = true;
             return ok;
         }   
         else
             ok = false;
         }
         
        return ok;
    }
    public Vector<Csv> readCsv() throws FileNotFoundException, IOException{
      String delimitatore = ",";
      File file = new File("Coordinate.csv");
      FileReader fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr);
      String line = " ";
      String[] tempArr;
      Vector<Csv> ArrCsv = null ;
      while ((line = br.readLine()) != null) {
        tempArr = line.split(delimitatore);
        ArrCsv.add( new Csv(Integer.parseInt(tempArr[0]), tempArr[1], tempArr[2], tempArr[3]));
        
        
      }
      br.close();
      return ArrCsv;
    }
    
}
