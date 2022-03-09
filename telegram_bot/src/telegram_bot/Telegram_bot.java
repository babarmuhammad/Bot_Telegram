/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegram_bot;
import java.util.Scanner;
import java.util.Vector;
import org.json.*;
import telegram_api.Functions;
import telegram_api.Message;
import telegram_api.Update;
import telegram_api.User;
import telegram_api.test;

/**
 *
 * @author babar_muhammad_anas
 */
public class Telegram_bot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Functions f = new Functions();
        String scelta = "0";
        do
        {
            System.out.println("\nScelta:");
            System.out.println("[1]GetMe\n[2]GetUpdates\n[3]SendMessage");

            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            scelta = myObj.nextLine();

            switch(scelta)
            {
                case "1":
                    User user = f.getMe();
                    System.out.println(user.ToString());
                    break;
                case "2":
                    Vector<Update> ArrayUpdates = f.getUpdates();
                    for(Update element:ArrayUpdates)
                    {
                        System.out.println(element.ToString());
                    }
                    break;
                case "3":
                    System.out.println("\ntesto:");
                    String text = myObj.nextLine();
                    System.out.println("");
                    
                    Message mess = f.sendMessage(text);
                    System.out.println(mess.ToString()); 
                    break;
            }
        }
        while(!scelta.equals("-1"));
    }
    
    
}
