package spookshop.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

import spookshop.base.IProduct;

public class SpookShopApplication {

	private final static String RESOURCE_FOLDER = "resources/";
	public final static String CART_FILE = "cart.csv";
	public final static String PRODUCTS_FILE = "products.csv";

	public void run() {

	}

	public static void writeFile(List<IProduct> items, String fileName) {
		try {
			FileWriter myWriter = new FileWriter(RESOURCE_FOLDER + fileName);

			StringBuilder sb = new StringBuilder();
			// Headers
			for (Field field : items.getFirst().getClass().getDeclaredFields()) {
				sb.append(field.getName()).append(", ");
			}
			sb.append("\n");
			items.forEach(item -> sb.append(item + "\n"));

			myWriter.write(sb.toString());
			myWriter.close();
		} catch (IOException e) {
			throwException(e);
		}
	}

	public static void readFile(String fileName) {
		try {
			FileReader reader = new FileReader(RESOURCE_FOLDER + fileName);
			BufferedReader br = new BufferedReader(reader);

			String line; 
      String[] headers = br.readLine().split(",");
      List<IProduct> products = new ArrayList<IProduct>();
      List<String[]> readVals = new ArrayList<String[]>();
      
      while((line = br.readLine()) != null){
        String[] rowVals = line.split(",");
        readVals.add(rowVals);
        new Product(rowVals[0], rowVals[1], rowVals[2]);
      }

      for(int i = 0; i < readVals.size(); i++){
        String header = headers[i];
      }
		} catch (IOException e) {
			throwException(e);
		}


	}

	private static void throwException(Exception e) {
		System.out.println("An error occurred.");
		e.printStackTrace(); // Print error details
	}
}
