package spookshop.main;

import java.util.List;

import spookshop.base.Inventory;
import spookshop.base.Product;
import spookshop.base.ProductFactory;
import spookshop.base.Category;

public class Main {

	public static void main(String[] args) {
    ProductFactory pf = new ProductFactory();
		List<Product> inventory = Inventory.getInstance();
    inventory.addObserver(new ConsoleDisplay()); 

		Product p = pf.createProduct();
    p.setName("Kava");
    p.setPrice(1.32f);
    p.setCategory(Category.BEVERAGE);

		Inventory.addItem(p);

		for (Product prod : inventory) {
			System.out.println(prod.toString());
		}

	}
}
