package spookshop.base;

import spookshop.base.Observer;
import spookshop.base.Product;

public class ConsoleDisplay implements Observer {
  private Product newProduct;

  @Override
  public void update(Product product){
    this.product = product;
    display();
  }
  
  private void display(){
    System.out.println("Pridetas naujas produktas: " + newProduct.toString());
  }
  
}
