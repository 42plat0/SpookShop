package spookshop.base;

import spookshop.base.IProductFactory;
import spookshop.base.Product;

public class ProductFactory implements IProductFactory{
  
  @Override
  public Product createProduct(){
    return new Product();
  }
}
