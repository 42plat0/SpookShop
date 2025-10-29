package spookshop.main;

import spookshop.base.Category;
import spookshop.base.ConsoleDisplay;
import spookshop.base.IProduct;
import spookshop.base.Inventory;
import spookshop.base.Product;
import spookshop.base.ProductFactory;
import spookshop.decorators.BloodyPackagingDecorator;
import spookshop.decorators.PackagingDecorator;

public class Main {

	public static void main(String[] args) {
		ProductFactory pf = new ProductFactory();
		Inventory inventory = Inventory.getInstance();
		inventory.addObserver(new ConsoleDisplay());

		Product p = pf.createProduct();
		// TODO create catalogue of products
		p.setName("Kava");
		p.setPrice(1.32f);
		p.setCategory(Category.BEVERAGE);

		inventory.addItem(p);

		for (IProduct prod : inventory.getItems()) {
			System.out.println(prod.toString());
			prod = new PackagingDecorator(prod);
			System.out.println(prod.toString());
			prod = new BloodyPackagingDecorator(prod);
			System.out.println(prod.toString());
		}

	}
}
