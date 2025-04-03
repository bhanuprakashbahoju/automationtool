package com.mycompany.packages;

public class PackageFactory {

    public static PackageType getPackage(String type) {
        switch (type.toLowerCase()) {
            case "plan":
                return new Plan();
            case "phase":
                return new Phase();
            default:
                throw new IllegalArgumentException("Unsupported package type: " + type);
        }
    }
}
