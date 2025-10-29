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

	public void setPrice(Object price) {
		if (price instanceof Float) {
			this.price = (Float) price;
		} else if (price instanceof String) {
			this.price = Float.valueOf((String) price);
		} else {
			this.price = 0f;
		}
	}

	@Override
	public Category getCategory() {
		return category;
	}

	public void setCategory(Object category) {
		if (category instanceof Category) {
			this.category = (Category) category;
		} else if (category instanceof String) {
			String c = ((String) category).toUpperCase().trim();
			// TODO ...
			if ("EDIBLE".equals(c)) {
				this.category = Category.EDIBLE;
			} else if ("BEVERAGE".equals(c)) {
				this.category = Category.BEVERAGE;
			} else if ("DEADLY".equals(c)) {
				this.category = Category.DEADLY;
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getName()).append(", ").append(getPrice()).append("$, ").append(getCategory());
		return sb.toString();
	}
}
