package HW19;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class Data {
    private static int productCounter = 0;

    public static String[] getProducts(){
    Properties props = new Properties();
        try {
        FileInputStream input = new FileInputStream("src/main/resources/data.properties");
        props.load(input);
        input.close();
    } catch (
    IOException e) {
        e.printStackTrace();
    }
    String[] products = props.getProperty("products").split(",");
    //String productName = products[productCounter % products.length].trim();

    productCounter++;
    return products;
    }
}
