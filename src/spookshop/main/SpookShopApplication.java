package spookshop.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import spookshop.base.IProduct;
import spookshop.base.Inventory;
import spookshop.base.Product;
import spookshop.base.ProductFactory;

public class SpookShopApplication {
	private final static String RESOURCE_FOLDER = "resources/";
	private final static String CART_FILE = "cart.csv";
	private final static String PRODUCTS_FILE = "products.csv";
	private final static Map<String, String> MENU_ITEMS = Map.of("1", "Peržiūrėti produktus", "2", "Susimokėti", "3",
			"Išeiti");

	private static Inventory inventory;

	public static void run() {
		initializeInventory();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			for (Entry<String, String> entry : MENU_ITEMS.entrySet()) {
				String key = entry.getKey();
				String value = entry.getValue();
				System.out.println(key + "." + value);

			}
			String input = scanner.nextLine();

			if (!MENU_ITEMS.keySet().contains(input)) {
				continue;
			}
			if (input.equals("3")) {
				break;
			}
		}
		System.out.println("Done");

	}

	private static void initializeInventory() {
		inventory = Inventory.getInstance();
		inventory.addItems(getInventoryProducts());

		for (IProduct product : inventory.getItems()) {
//			System.out.println(product.toString());
		}

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

	public static List<String[]> readFile(String fileName) {
		try {
			FileReader reader = new FileReader(RESOURCE_FOLDER + fileName);
			BufferedReader br = new BufferedReader(reader);

			String line = br.readLine(); // remove headers
			List<String[]> readVals = new ArrayList<String[]>();

			while ((line = br.readLine()) != null) {
				String[] rowVals = line.split(",");
				readVals.add(rowVals);
			}
			return readVals;

		} catch (IOException e) {
			throwException(e);
		}
		return null;
	}

	private static List<IProduct> getInventoryProducts() {
		List<IProduct> products = new ArrayList<IProduct>();
		List<String[]> productRows = readFile(PRODUCTS_FILE);
		ProductFactory pf = new ProductFactory();

		for (String[] productRow : productRows) {
			Product product = pf.createProduct();
			// TODO ...
			product.setName(productRow[0]);
			product.setPrice(productRow[1]);
			product.setCategory(productRow[2]);
			products.add(product);
//
		}
		return products;
	}

	private static void throwException(Exception e) {
		System.out.println("An error occurred.");
		e.printStackTrace(); // Print error details
	}
}
