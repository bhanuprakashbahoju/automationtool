package com.mycompany.transformation;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mycompany.loader.JsonNavigator;
import com.mycompany.loader.Package;
import com.mycompany.packages.PackageFactory;
import com.mycompany.packages.PackageType;

public class Parser {
    Package pack;

    public Parser(Package pack){
        this.pack = pack;
    }
    public void parseData(){

        // Parse plan data
        PackageType planPack= PackageFactory.getPackage("plan");
        String[] path = planPack.getPath();
        JsonElement planTarget = JsonNavigator.navigate(pack.getJsonObject(), path);
        planPack.parseAttributes(planTarget.getAsJsonObject());
        planPack.printAttributes();

        // Parse Phase data
        PackageType phasePack = PackageFactory.getPackage("phase");
        String[] phasePath = phasePack.getPath();
        JsonElement phaseElement = JsonNavigator.navigate(pack.getJsonObject(), phasePath);


        if (phaseElement != null) {
            if (phaseElement.isJsonArray()) {
                // Loop through each element if it's an array
                JsonArray array = phaseElement.getAsJsonArray();
                for (JsonElement element : array) {
                    if (element.isJsonObject()) {
                        phasePack.parseAttributes(element.getAsJsonObject());
                        phasePack.printAttributes();
                    }
                }
            } else if (phaseElement.isJsonObject()) {
                // Directly parse if it's a single object
                phasePack.parseAttributes(phaseElement.getAsJsonObject());
            } else {
                System.out.println("Unexpected JSON structure at path: " + String.join("/", path));
            }
        } else {
            System.out.println("Invalid path for package type: " + phasePack.getClass().getSimpleName());
        }
    }
}
