package com.mycompany.packages;

import com.google.gson.JsonObject;
import com.mycompany.logger.Logger;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phase implements PackageType {

    private Map<String, String> attributes = new HashMap<>();

    // Attributes to be loaded
    private static final List<String> planAttributes = Arrays.asList("name", "description", "status");

    @Override
    public void parseAttributes(JsonObject jsonObject) {
        Logger.log("\n================Parsing Phase Details================\n");
        for (String attr : planAttributes) {
            if (jsonObject.has(attr)) {
                attributes.put(attr, jsonObject.get(attr).getAsString());
            } else {
                attributes.put(attr, "N/A");  // Placeholder if attribute is missing
            }
        }
    }

    @Override
    public void printAttributes() {
        Logger.log("\nPlan Attributes:\n");
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    @Override
    public String[] getPath(){
        return new String[]{"phase"};
    }
}
