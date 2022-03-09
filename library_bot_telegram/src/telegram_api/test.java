/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegram_api;
import org.json.*;
/**
 *
 * @author babar_muhammad_anas
 */
public class test {
    public void foo(){
        

        String jsonString = "{nome:'mario',messaggi:['ciao','mondo']}" ; //assign your JSON String here
        JSONObject obj = new JSONObject(jsonString);
        String name = obj.getString("nome");
        System.out.println(name);
        JSONArray arr = obj.getJSONArray("messaggi"); // notice that `"posts": [...]`
        for (int i = 0; i < arr.length(); i++)
        {
            String messaggi = arr.getString(i);
            System.out.println(messaggi);
            /*String post_id = arr.getJSONObject(i).getString("post_id");
            ......*/
        }
    }
}
