package kioskassignment;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<MenuItem> cart = new ArrayList<>();
    private List<MenuItem> deleteList = new ArrayList<>();

    public void addCart(MenuItem menuItem) {
        cart.add(menuItem);
    }

    public List<MenuItem> getCart() {
        return this.cart;
    }

    public void setCart(int cartNumber, MenuItem menuItem) {
        cart.set(cartNumber, menuItem);
    }

    public void removeCart(int cartNumber) {
        cart.remove(cartNumber);
    }

    public void printCart() {
        System.out.println("[CART]");
        int index = 0;
        for (MenuItem d : getCart()) {
            ++index;
            System.out.println("--------------------");
            System.out.println("[" + index + "]" + " " + d.getName() + " " + d.getPrice() + " " + d.getContents());
        }
        System.out.println("--------------------");
    }

    public Integer getTotalCartPrice() {
        Integer totalCartPrice = 0;
        for (MenuItem d : getCart()) {
            totalCartPrice += d.getPrice();
        }
        return totalCartPrice;
    }

    public void addDeleteList(MenuItem menuItem) {
        deleteList.add(menuItem);
    }

    public List<MenuItem> getDeleteList() {
        return this.deleteList;
    }

    public void setDeleteList(int deleteNumber, MenuItem menuItem) {
        cart.set(deleteNumber, menuItem);
    }

    public void removeDeleteList(int deleteNumber) {
        deleteList.remove(deleteNumber);
    }

    public void clearDeleteList() {
        deleteList.clear();
    }

    public void printDeleteList() {
        System.out.println("[DELETE]");
        int index = 0;
        for (MenuItem d : deleteList) {
            ++index;
            System.out.println("--------------------");
            System.out.println("[" + index + "]" + " " + d.getName() + " " + d.getPrice() + " " + d.getContents());
        }
        System.out.println("--------------------");
    }
    public void printRemoveProcess1() {
        printCart();
        if (getDeleteList().isEmpty()) {
            System.out.println("장바구니에서 빼실 품목의 번호를 한 개씩 입력해주세요");
            System.out.println((getCart().size() + 1) + ". 처음으로   | 처음으로");
        } else {
            printDeleteList();
            if (!getCart().isEmpty()) {
                System.out.println("장바구니에서 빼실 품목의 번호를 한 개씩 입력해주세요");
            }
                System.out.println("장바구니로 되돌리기를 원하실 경우 [DELETE]품목번호 앞에 -를 붙여 한 개씩 입력해주세요. ex) -1 // -3");
                System.out.println((getCart().size() + 1) + ". 처음으로   | 처음으로");
                System.out.println((getCart().size() + 2) + ". 취소하기   | 취소하기");
        }
        System.out.println("0. 종료      | 종료");
    }

    public void printRemoveProcess2() {
        printCart();
        if (getDeleteList().isEmpty()) {
            System.out.println("장바구니에서 빼실 품목의 번호를 한 개씩 입력해주세요");
            System.out.println((getCart().size() + 1) + ". 이전으로   | 이전으로");
            System.out.println((getCart().size() + 2) + ". 처음으로   | 처음으로");
        } else {
            printDeleteList();
            if (!getCart().isEmpty()) {
                System.out.println("장바구니에서 빼실 품목의 번호를 한 개씩 입력해주세요");
            }
                System.out.println("장바구니로 되돌리기를 원하실 경우 [DELETE]품목번호 앞에 -를 붙여 한 개씩 입력해주세요. ex) -1 // -3");
                System.out.println((getCart().size() + 1) + ". 이전으로   | 이전으로");
                System.out.println((getCart().size() + 2) + ". 처음으로   | 처음으로");
                System.out.println((getCart().size() + 3) + ". 취소하기   | 취소하기");
        }
        System.out.println("0. 종료      | 종료");
    }
}