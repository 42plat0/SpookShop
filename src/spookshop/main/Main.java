package spookshop.main;

import java.util.List;

import spookshop.base.Inventory;
import spookshop.base.Product;
import spookshop.base.ProductFactory;
import spookshop.base.Category;

public class Main {

	public static void main(String[] args) {
    ProductFactory pf = new ProductFactory();
		List<Product> inv = Inventory.getInstance();

		Product p = pf.createProduct();
    p.setName("Kava");
    p.setPrice(1.32f);
    p.setCategory(Category.BEVERAGE);

		Inventory.addItem(p);

		for (Product prod : inv) {
			System.out.println(prod.toString());
		}

	}
}
