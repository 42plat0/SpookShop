package spookshop.decorators;

import spookshop.base.IProduct;

public class BloodyPackagingDecorator extends ProductDecorator {
	private final Float packagingPrice = 0.3f;

	public BloodyPackagingDecorator(IProduct product) {
		super(product);
	}

	@Override
	public String getName() {
		return "Kruvina " + super.getName();
	}

	@Override
	public Float getPrice() {
		return super.getPrice() + packagingPrice;
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
