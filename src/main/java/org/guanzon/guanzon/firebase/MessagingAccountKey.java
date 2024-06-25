package org.guanzon.guanzon.firebase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MessagingAccountKey {    
    public static FileInputStream get(String fsProdctID) throws FileNotFoundException{
        switch (fsProdctID.toLowerCase()){
            case "grider":
                return new FileInputStream(System.getProperty("sys.default.path.config") + "/config/keys/gcircle.json");
            case "integsys":
                return new FileInputStream(System.getProperty("sys.default.path.config") + "/config/keys/gconnect.json");
            default:
                return null;
        }
    }
}
