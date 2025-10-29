package spookshop.main;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

import spookshop.base.IProduct;

public class SpookShopApplication {

	private final static String RESOURCE_FOLDER = "resources/";
	public final static String CART_FILE = "cart.csv";
	public final static String PRODUCTS_FILE = "product.csv";

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
			System.out.println("An error occurred.");
			e.printStackTrace(); // Print error details
		}
	}

	public static void readFile() {

	}
}
