package com.main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvWriteFile {
    private static final String COMMA_DELIMITER = ", ";
    private static final String NEW_LINE_SEPARATOR = "\n";

    private static Object Product;

    public static void main(String[] args) {
        String fileName = "product.csv";
        writeCsvFile(fileName);

        String csvReadFile = "product.csv";
        String line = "";
        String cvsSplitBy = COMMA_DELIMITER;
        System.out.println();
        System.out.println("Read file product.csv:");
        try (BufferedReader br = new BufferedReader(new FileReader(csvReadFile))) {

            while ((line = br.readLine()) != null) {
                String[] product = line.split(cvsSplitBy);
                if (product.length == 4) {
                    String id = product[0];
                    String name = product[1];
                    String price = product[2];
                    String desc = product[3];
                    System.out.println("id: " + id + ", name: " + name + ", price: " + price + ", decs: " + desc);
                }

//                for (int i = 0; i < product.length; i++) {
//                    System.out.println(product[i]);
//                }
//                System.out.println("Product [id= " + product[3] + " , name=" + product[3] + " , price=" + product[3] + " , desc=" + product[3] + "]");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeCsvFile(String fileName) {
        Product product = new Product(1, "HyperXMouse", "100", "new");
        Product product1 = new Product(2, "Iphone6", "100", "newLike");
        Product product2 = new Product(3, "Iphone7plus", "100", "new");
        Product product3 = new Product(4, "Iphone8s", "300", "new");

        List<Product> productList = new ArrayList<>();
        productList.add(product);
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName);
//            fileWriter.append(NEW_LINE_SEPARATOR);

            for (Product p : productList) {
                fileWriter.append(String.valueOf(p.getId()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(p.getName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append((p.getPrice()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(p.getDescription());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            System.out.println("CSV file was created successfully!");
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}
