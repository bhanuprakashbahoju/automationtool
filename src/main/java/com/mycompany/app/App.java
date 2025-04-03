package com.mycompany.app;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("./resources/@BEEPPlans@a098a3.json")) {
            JsonElement element = JsonParser.parseReader(reader);
            parseJson(element, "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    } 
    private static void parseJson(JsonElement element, String indent) {
        if (element.isJsonObject()) {
            JsonObject obj = element.getAsJsonObject();
            for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
                System.out.println(indent + "Key: " + entry.getKey() + ", Value: " + entry.getValue());
//                parseJson(entry.getValue(), indent + "  ");
            }
        } else if (element.isJsonArray()) {
            JsonArray array = element.getAsJsonArray();
            for (JsonElement item : array) {
                System.out.println(indent + "- Array Element:");
//                parseJson(item, indent + "  ");
            }
        } else if (element.isJsonPrimitive()) {
            System.out.println(indent + "Value: " + element.getAsString());
        } else if (element.isJsonNull()) {
            System.out.println(indent + "Value: null");
        }
    }
}
