package spookshop.base;

public class ConsoleDisplay implements Observer {
	private IProduct product;

	@Override
	public void update(Object o) {
		if (o instanceof IProduct) {
			this.product = (IProduct) o;
			display();
		}
	}

	private void display() {
		System.out.println("Pridetas naujas produktas: " + product.toString());
	}

}
