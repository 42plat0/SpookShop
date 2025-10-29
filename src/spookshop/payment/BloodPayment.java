package spookshop.payment;

import java.util.List;

import spookshop.base.IProduct;

public class BloodPayment implements PaymentStrategy {
	private final Integer bloodPricePerLitre = 1000;

	@Override
	public void pay(List<IProduct> items) {
		Float total = 0f;

		for (IProduct product : items) {
			total += product.getPrice();
		}

		System.out.println("Viso moketi " + (total / bloodPricePerLitre) + " litrų kraujo");
	}

}