package spookshop.base;

public class ConsoleDisplay implements Observer {
	private Product product;

	@Override
	public void update(Object o) {
		if (o instanceof Product) {
			this.product = (Product) o;
			display();
		}
	}

	private void display() {
		System.out.println("Pridetas naujas produktas: " + product.toString());
	}

}
