package spookshop.base;

import java.util.ArrayList;
import java.util.List;

public class Inventory implements Observable {
	private static Inventory inventory;
	private List<Product> items;
	private List<Observer> observers = new ArrayList<Observer>();

	private Inventory() {
	}

	public static Inventory getInstance() {
		if (inventory == null) {
			inventory = new Inventory();
		}
		return inventory;
	}

	public void addItem(Product product) {
		if (items == null) {
			items = new ArrayList<Product>();
		}
		items.add(product);
		notifyObservers(product);
	}

	public List<Product> getItems() {
		return items;
	}

	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers(Object o) {
		for (Observer observer : observers) {
			observer.update(o);
		}

	}

}
