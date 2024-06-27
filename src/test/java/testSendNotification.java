
import org.guanzon.guanzon.firebase.Messaging;
import org.json.simple.JSONObject;

public class testSendNotification {
    public static void main(String [] args){
        String path;
        if(System.getProperty("os.name").toLowerCase().contains("win")){
            path = "D:/GGC_Maven_Systems";
        }
        else{
            path = "/srv/GGC_Maven_Systems";
        }
        System.setProperty("sys.default.path.config", path);
        
        JSONObject loJSON = new JSONObject();
        loJSON.put("title", "Test Notification");
        loJSON.put("message", "Test Notification Body");
        loJSON.put("imgurl", "");
        loJSON.put("msg_data", new JSONObject());
        
        Messaging message = new Messaging("IntegSys");
        
        loJSON = message.send("e32-tiqeQVyGg2Fe6nSTgI:APA91bGuoFI6q6-xB3jQxPp8a2upo-JEX_mqnPHx7mggH5CME9wp6LdTXyTclyMQsMr_G4_1hxMF9DDAIfrwgmVnr2S-Wx4pYSJVh8d1v5ArTbKt0IcJtm7Zm0WlmQc_ElgH4VlbIpjw", loJSON);
        System.out.println(loJSON);
    }
}
