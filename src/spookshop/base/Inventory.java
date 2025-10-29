package spookshop.base;

import java.util.ArrayList;
import java.util.List;

public class Inventory implements Observable {
	private static Inventory inventory;
	private List<IProduct> items;
	private List<Observer> observers = new ArrayList<Observer>();

	private Inventory() {
	}

	public static Inventory getInstance() {
		if (inventory == null) {
			inventory = new Inventory();
		}
		return inventory;
	}

	public void addItem(IProduct product) {
		if (items == null) {
			items = new ArrayList<IProduct>();
		}
		items.add(product);
		notifyObservers(product);
	}

	public void addItems(IProduct... products) {
		for (IProduct product : products) {
			addItem(product);
		}
	}

	public List<IProduct> getItems() {
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
