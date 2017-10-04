package com.thirdspare.discordbot.Mod;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConfigManager {

public static JSONObject getConfig(String guildID){
        JSONObject config;
        try{
            config = new JSONObject(new String(Files.readAllBytes(Paths.get("config/" + guildID + ".json"))));
            return config;
        }catch(JSONException e){
            return null;
        }catch (IOException e){
            return null;
        }


}
public static void saveConfig(String guildID, String mutedID, String modID, String logID){


    try {
        FileWriter fw = new FileWriter("config/" + guildID + ".json");
        fw.close();
        JSONObject config = new JSONObject();
        config.put("muted", mutedID);
        config.put("mod", modID);
        config.put("log", logID);
        fw.write(config.toString(2));
        fw.close();
    }catch(JSONException e){
        e.printStackTrace();
    }catch (IOException e) {
        e.printStackTrace();
    }

}
}
