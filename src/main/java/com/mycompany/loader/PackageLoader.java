package com.mycompany.loader;

import com.google.gson.*;
import com.mycompany.logger.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PackageLoader {

    public Package loadPackage(){
        try (FileReader reader = new FileReader(
                "./resources/@BEEPPlans@a098a3.json")) {
            Logger.log("=========Loading Dependent Packages=======");
            JsonElement element = JsonParser.parseReader(reader);
            Package planPackage = new Package(element.getAsJsonObject());
            loadDependentPackages(planPackage);
//            parseJson(element, "");
            return planPackage;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void loadDependentPackages(Package pack){

        if(pack.has("dependentPackage")) {
            // Get List of dependentPackages
            List<String> dependentPackages = new ArrayList<>();
            JsonElement dependentPackagesElemet = pack.get("dependentPackage");
            if (dependentPackagesElemet.isJsonArray()) {
                JsonArray array = dependentPackagesElemet.getAsJsonArray();
                for (JsonElement item : array) {
                    System.out.println("Loaded DependentPackage " + item);
                    dependentPackages.add(item.getAsString());
                }
            }
            //Load the Packages;

        }
    }
}
