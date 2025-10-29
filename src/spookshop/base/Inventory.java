package spookshop.base;

import java.util.List;
import java.util.ArrayList;
import spookshop.base.Product;
import spookshop.base.Observable;
import spookshop.base.Observer;

public class Inventory implements Observable {
  private static List<Product> items;
  private List<Observer> observers;

  private Inventory(){}

  public static List<Product> getInstance(){
    if (items == null){
      items = new ArrayList<Product>();
    }
    return items;
  }
  
  public static void addItem(Product product){
    if (items == null){
      items = new ArrayList<Product>();
    }
    items.add(product);
    notifyObservers();
  }

  @Override
  public void addObserver(Observer observer){
    observers.add(observer);
  }

  @Override
  public void removeObserver(Observer o){
    observers.remove(observer);
  }

  @Override
  public void notifyObservers(){
    for (Observer observer : observers){
      observer.update();
    }

  }

}
