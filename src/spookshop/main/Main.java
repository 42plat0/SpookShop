package spookshop.main;

import spookshop.base.Category;
import spookshop.base.ConsoleDisplay;
import spookshop.base.IProduct;
import spookshop.base.Inventory;
import spookshop.base.Product;
import spookshop.base.ProductFactory;
import spookshop.decorators.BloodyPackagingDecorator;
import spookshop.decorators.PackagingDecorator;
import spookshop.payment.BloodPayment;
import spookshop.payment.PaymentContext;
import spookshop.payment.PaymentStrategy;

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

		IProduct prod1 = new PackagingDecorator(p);
		IProduct prod2 = new BloodyPackagingDecorator(prod1);
		inventory.addItems(p, prod1, prod2);
		for (IProduct prod : inventory.getItems()) {
			System.out.println(prod.toString());
		}

		PaymentContext context = new PaymentContext();
		PaymentStrategy payment = new BloodPayment();
		context.setStrategy(payment);
		context.pay(inventory.getItems());
	}
}
