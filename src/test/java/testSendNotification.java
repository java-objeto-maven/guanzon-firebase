
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
        loJSON.put("title", "Pasok");
        loJSON.put("message", "Pasok 123");
        loJSON.put("imgurl", "");
        loJSON.put("msg_data", new JSONObject());
        
        Messaging message = new Messaging("gRider");
        
        loJSON = message.send("ddS5EhstSmiP7RbEAjXIAm:APA91bHNWHxYDfSxbUpEZ6Kr-kL-bo2rjxDacjtxHd5kZGM0pzenseEyquBW7TmgVDEIqJXkLyrmboLpRUDU_PB5wbIF1DclUbLjhvUhJhQqN0xm-BHIKFGHxm86p_nqwYnXOmoFU9Qv", loJSON);
        System.out.println(loJSON);
    }
}
