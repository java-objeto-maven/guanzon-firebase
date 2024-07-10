
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
        
        Messaging message = new Messaging("gRider");
        
        loJSON = message.send("dLVyOiYYSMq2tDe7ZXCTvs:APA91bHOFU0tLkPZGJiuMkeTVK1oWPNBQ9NxicDhZ53i6dWif3qwVOfIjp390Ro9xXFmx1ZCtvqDAkaAuiL3y_TEz759A10HKxO8cnHgPAfvR_Z1ziH_A9x7pqO_9OUZbrNHUvv75O7p", loJSON);
        System.out.println(loJSON);
    }
}
