package spookshop.decorators;

import spookshop.base.IProduct;

public class PackagingDecorator extends ProductDecorator {
	private final Float packagingPrice = 0.5f;

	public PackagingDecorator(IProduct product) {
		super(product);
	}

	@Override
	public String getName() {
		return "Supakuota " + super.getName();
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
