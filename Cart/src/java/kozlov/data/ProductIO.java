package kozlov.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import kozlov.business.Product;

public class ProductIO {
    
    public static boolean add(Product product, String filepath) {
        try {
            File file = new File(filepath);
            PrintWriter out = new PrintWriter(
                    new FileWriter(file, true));
            out.println(product.getCode()+ "|"
                    + product.getDescription()+ "|"
                    + product.getPrice());

            out.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static Product getProduct(String code, String filepath) {
        try {
            File file = new File(filepath);
            Product product;
            try (BufferedReader in = new BufferedReader(
                    new FileReader(file))) {
                product = new Product();
                String line = in.readLine();
                while (line != null) {
                    StringTokenizer t = new StringTokenizer(line, "|");
                    if (t.countTokens() < 3) {
                        return new Product();
                    }
                    String token = t.nextToken();
                    if (token.equalsIgnoreCase(code)) {
                        String description = t.nextToken();
                        String price = t.nextToken();
                        product.setCode(code);
                        product.setDescription(description);
                        product.setPrice(Double.parseDouble(price));
                    }
                    line = in.readLine();
                }
            }
            return product;
        } catch (IOException e) {
            return null;
        }
    }

    public static ArrayList<Product> getProducts(String filepath) {
        try {
            ArrayList<Product> products = new ArrayList<>();
            try (BufferedReader in = new BufferedReader(
                    new FileReader(filepath))) {
                String line = in.readLine();
                while (line != null) {
                    StringTokenizer t = new StringTokenizer(line, "|");
                    String code = t.nextToken();
                    String description = t.nextToken();
                    String price = t.nextToken();
                    Product product = new Product(code, description, Double.parseDouble(price));
                    products.add(product);
                    line = in.readLine();
                }
            }
            return products;
        } catch (IOException e) {
            return null;
        }
    }
}
