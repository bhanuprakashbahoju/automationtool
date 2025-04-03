package com.mycompany;

import com.mycompany.loader.Package;
import com.mycompany.loader.PackageLoader;
import com.mycompany.transformation.Parser;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try {
            PackageLoader loader = new PackageLoader();
            Package pack = loader.loadPackage();
            Parser parser = new Parser(pack);
            parser.parseData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
