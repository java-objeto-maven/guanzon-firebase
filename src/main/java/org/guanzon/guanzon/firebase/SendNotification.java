package org.guanzon.guanzon.firebase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.guanzon.appdriver.base.GRider;

public class SendNotification {
    public static void main(String[] args) {
        String path;
        
        if(System.getProperty("os.name").toLowerCase().contains("win")){
            path = "D:/GGC_Maven_Systems";
        }
        else{
            path = "/srv/GGC_Maven_Systems";
        }
        System.setProperty("sys.default.path.config", path);
        
        try {
            Properties po_props = new Properties();
            po_props.load(new FileInputStream(path + "/config/cas.properties"));
            
            if (po_props.getProperty("developer.mode").equals("1")){
                GRider instance = new GRider("gRider");
        
                if (!instance.logUser("gRider", "M001000001")){
                    System.err.println(instance.getErrMsg());
                    System.exit(1);
                }
                
//                if(args.length == 0){
//                    sendRequest();
//                    System.exit(0);
//                }
//
//                String method = args[0];
//                String transno = args[1];
//
//                if(method.equalsIgnoreCase("request")){
//                    sendRequest(transno);
//                    System.exit(0);
//                }
//                else{
//                    if(args.length != 5){
//                        System.exit(1);
//                    }
//
//                    String rcpt_app = args[2];
//                    String rcpt_usr = args[3];
//                    String imei = args[4];
//                    if(updateStatus(transno, rcpt_app, rcpt_usr, imei))
//                    {
//                        System.exit(0);
//                    }
//                    else{
//                        System.exit(1);
//                    }
//                }
            }
        } catch (IOException e) {
            System.exit(1);
        }
    }
}
