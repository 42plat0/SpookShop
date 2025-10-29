package spookshop.base;

public class Product implements IProduct {

	private String name;
	private Float price;
	private Category category;

	public Product() {
	}

	public Product(String name, Float price, Category category) {
		this.name = name;
		this.price = price;
		this.category = category;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@Override
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Produktas: ").append(getName()).append(", ").append(getPrice()).append("$, ").append(getCategory());
		return sb.toString();
	}
}
