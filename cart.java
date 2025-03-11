package kioskassignment;

import java.util.ArrayList;
import java.util.List;

public class cart {
    private List<MenuItem> cart = new ArrayList<>();

 public List<MenuItem> getCart () {
     return this.cart;
 }

 public void  setCart(int setNumber, MenuItem menuItem) {
     cart.set(setNumber, menuItem);
 }
}
