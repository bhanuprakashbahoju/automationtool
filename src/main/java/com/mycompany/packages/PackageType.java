package com.mycompany.packages;

import com.google.gson.JsonObject;

public interface PackageType {
    void parseAttributes(JsonObject jsonObject);
    void printAttributes();
    String[] getPath();
}
