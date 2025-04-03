package com.mycompany.loader;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class JsonNavigator {
    public static JsonElement navigate(JsonObject root, String[] path) {
        JsonObject current = root;
        for (String step : path) {
            if (current.has(step) && current.get(step).isJsonObject()) {
                current = current.getAsJsonObject(step);
            } else if((current.has(step) && current.get(step).isJsonArray())) {
                return current.get(step); // Return null if the path is invalid
            }else{
                return null;
            }
        }
        return current;
    }
}
