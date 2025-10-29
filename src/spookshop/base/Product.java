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
    if (price instanceof Float){
      this.price = price;
    } else if (price instanceof String){
      this.price = Float.valueOf(price);
    } else{
      this.price = 0;
    }
	}

	@Override
	public Category getCategory() {
		return category;
	}

	public void setCategory(Object category) {
    if (category instanceof Category){
      this.category = category;
    } else if (category instanceof String){
      Category[] categories = Category.getDeclaringClass().getEnumConstants(); 
      for (Category category : categories){
        System.out.println(category.name());
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
