package spookshop.main;

import spookshop.base.Category;
import spookshop.base.ConsoleDisplay;
import spookshop.base.Inventory;
import spookshop.base.Product;
import spookshop.base.ProductFactory;

public class Main {

	public static void main(String[] args) {
		ProductFactory pf = new ProductFactory();
		Inventory inventory = Inventory.getInstance();
		inventory.addObserver(new ConsoleDisplay());

		Product p = pf.createProduct();
		p.setName("Kava");
		p.setPrice(1.32f);
		p.setCategory(Category.BEVERAGE);

		inventory.addItem(p);

		for (Product prod : inventory.getItems()) {
			System.out.println(prod.toString());
		}

	}
}
