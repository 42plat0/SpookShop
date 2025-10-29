package spookshop.base;

public class ProductFactory implements IProductFactory {

	@Override
	public Product createProduct() {
		return new Product();
	}
}
