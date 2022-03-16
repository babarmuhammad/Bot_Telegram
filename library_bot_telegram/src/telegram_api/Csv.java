/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegram_api;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

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
    
    public void toCsv(int id_chat, String nome, String coordinate) throws FileNotFoundException{
        //String s = "";
        PrintWriter pw = null;
        
        pw = new PrintWriter(new File("Coordinate.csv"));
        
        StringBuilder builder = new StringBuilder();
        String columnNamesList = "id_chat,nome,lat,lon";
        // No need give the headers Like: id, Name on builder.append
        builder.append(columnNamesList +"\n");
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
         BufferedReader read;
         read = new BufferedReader(new FileReader ("Coordinate.csv"));
         String line;
         while( read.readLine() != null){
             
         }
         
         
        return ok;
    }
    
    
}
