
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
        loJSON.put("title", "Notification Title");
        loJSON.put("message", "Testing ito");
        loJSON.put("imgurl", "");
        loJSON.put("msg_data", "");
        
        Messaging message = new Messaging("gRider");
        
        loJSON = message.send("eaHLk2hrTjq1dDcycgomdo:APA91bFtCKuqm2debiRgzirk7sXfH28QRf-Poto2-UdzboNL7fvtrslTCSw9WGVBTygqXg9mJtYKjg7q17Ny-3c3siviMIepNnB17ih7JDxPgsYiCfAPMTl6IBAvbLMgVecmTtZDlDy3", loJSON);
        System.out.println(loJSON);
    }
}
