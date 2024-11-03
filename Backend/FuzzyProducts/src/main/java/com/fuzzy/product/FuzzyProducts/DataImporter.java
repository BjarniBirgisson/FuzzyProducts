package com.fuzzy.product.FuzzyProducts;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DataImporter {

    /**
     * DataImporter for reading a tab separated file line by line.
     * @param filePath of the file to read
     * @return List of Products read from the file.
     */
    public static ArrayList<Product> importData(String filePath) {
        ArrayList<Product> list = new ArrayList<Product>();
        
        try {
            // Open the file
            FileInputStream fstream = new FileInputStream(filePath);

            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String strLine;

            // Read File Line By Line
            while ((strLine = br.readLine()) != null) {
                // Split the line on Tabs
                String[] product = strLine.split("\t");
                // Check length of psplit array to see that all attributes present
                if (product.length == 5) {
                    Product p = new Product(product[0], product[1], product[2], Float.parseFloat(product[4]),
                            product[3]);
;                    list.add(p);
                }
            }
            // Close the input stream
            in.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return list;
    }

}
