package spookshop.payment;

import java.util.List;

import spookshop.base.IProduct;

public class PaymentContext {
	private PaymentStrategy paymentStrategy;

	public void setStrategy(PaymentStrategy paymentStrategy) {
		this.paymentStrategy = paymentStrategy;
	}

	public void pay(List<IProduct> items) {
		paymentStrategy.pay(items);
	}
}
