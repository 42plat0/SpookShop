package spookshop.base;

import java.util.List;
import java.util.ArrayList;
import spookshop.base.Product;

public class Inventory {
  private static List<Product> items;

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
  }

}
