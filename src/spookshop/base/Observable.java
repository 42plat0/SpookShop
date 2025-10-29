package spookshop.base;

import spookshop.base.Observer;

public interface Observable {
  void addObserver(Observer o);
  void removeObserver(Observer o);
  void notifyObservers();
}
