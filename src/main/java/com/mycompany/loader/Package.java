package com.mycompany.loader;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.List;

public class Package {
    public List<Package> dependentePakcages;
    public  String type;

    JsonObject head;

    public Package(JsonObject head){
        this.head = head;
        this.type = head.has("type") ? head.get("type").getAsString() : "Unknown";
    }

    public boolean has(String key) {
        return head.has(key);
    }
    public JsonElement get(String key){
        return head.get(key);
    }
    public JsonObject getJsonObject(){
        return head;
    }

}
