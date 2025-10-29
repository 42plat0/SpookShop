package spookshop.payment;

import java.util.List;

import spookshop.base.IProduct;

public class CashPayment implements PaymentStrategy {

	@Override
	public void pay(List<IProduct> items) {
		Float total = 0f;

		for (IProduct product : items) {
			total += product.getPrice();
		}

		System.out.println("Viso moketi " + total + "$");
	}
}
