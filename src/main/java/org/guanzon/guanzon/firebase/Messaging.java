package org.guanzon.guanzon.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import java.io.IOException;
import org.json.simple.JSONObject;

public class Messaging {
    /**
     * public Messaging(String fsProdctID){
     * 
     * @param fsProdctID 
     * \n
     * gRider - Guanzon Circle\n
     * GuanzonApp - Guanzon Connect\n
     */
    public Messaging(String fsProdctID){
        try {
            FirebaseOptions options = new FirebaseOptions.Builder()
            .setCredentials(GoogleCredentials.fromStream(MessagingAccountKey.get(fsProdctID)))
            .build();

            FirebaseApp.initializeApp(options);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }        
    }
    
    public JSONObject send(String to_key, JSONObject msg_data){
        if (to_key == null){
            msg_data.put("result", "error");
            
            JSONObject err = new JSONObject();
            err.put("code", 101);
            err.put("message", "Receiver token is null.");
            msg_data.put("error", err);
            
            return msg_data;
        }
        
        Message message = Message.builder()
            .putData("title", (String) msg_data.get("title"))
            .putData("message", (String) msg_data.get("message"))
            .putData("imgurl", (String) msg_data.get("imgurl"))
            .putData("msg_data", ((JSONObject) msg_data.get("msg_data")).toJSONString())
            .setToken(to_key)
            .build();
        
        msg_data = new JSONObject();
        
        try {
            String response = FirebaseMessaging.getInstance().send(message);
            
            msg_data.put("result", "success");
            msg_data.put("payload", response);
            
        } catch (FirebaseMessagingException e) {
            msg_data.put("result", "error");
            
            JSONObject err = new JSONObject();
            err.put("code", 100);
            err.put("message", e.getMessage());
            msg_data.put("error", err);
        }
        
        return msg_data;
    }
}
