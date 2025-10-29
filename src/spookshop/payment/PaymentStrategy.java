package spookshop.payment;

import java.util.List;

import spookshop.base.IProduct;

public interface PaymentStrategy {

	void pay(List<IProduct> items);
}
