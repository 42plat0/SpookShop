package spookshop.base;

public class Product {

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Item: ").append(name).append(", ").append(price).append("$, ").append("category: ").append(category);
		return sb.toString();
	}
}
