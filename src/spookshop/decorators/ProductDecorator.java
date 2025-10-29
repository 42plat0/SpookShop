package spookshop.decorators;

import spookshop.base.Category;
import spookshop.base.IProduct;

public class ProductDecorator implements IProduct {
	protected IProduct product;

	public ProductDecorator(IProduct product) {
		this.product = product;
	}

	@Override
	public String getName() {
		return product.getName();
	}

	@Override
	public Float getPrice() {
		return product.getPrice();
	}

	@Override
	public Category getCategory() {
		return product.getCategory();
	}

	private String getFormattedPrice(Float price) {
		return String.format("%.2f", price);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Produktas: ").append(getName()).append(", ").append(getFormattedPrice(getPrice())).append("$, ")
				.append(getCategory());
		return sb.toString();
	}
}