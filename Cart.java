package kioskassignment;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    //속성
    private List<MenuItem> cart = new ArrayList<>();
    private List<MenuItem> cancelList = new ArrayList<>();

    //메서드
    //장바구니에 물품을 추가하는 메서드
    public void addCart(MenuItem menuItem) {
        cart.add(menuItem);
    }

    //장바구니리스트를 반환하는 메서드
    public List<MenuItem> getCart() {
        return this.cart;
    }

    //장바구니리스트를 설정하는 메서드
    public void setCart(int cartNumber, MenuItem menuItem) {
        cart.set(cartNumber, menuItem);
    }

    //장바구니리스트에서 물품을 빼는 메서드
    public void removeCart(int cartNumber) {
        cart.remove(cartNumber);
    }

    //장바구니리스트를 전체 출력하는 메서드
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

    //장바구니리스트의 전체 가격의 합을 반환해주는 메서드
    public Integer getTotalCartPrice() {
        Integer totalCartPrice = 0;
        for (MenuItem d : getCart()) {
            totalCartPrice += d.getPrice();
        }
        return totalCartPrice;
    }

    //취소리스트에 물품을 추가하는 메서드
    public void addCancelList(MenuItem menuItem) {
        cancelList.add(menuItem);
    }

    //취소리스트를 반환하는 메서드
    public List<MenuItem> getCancelList() {
        return this.cancelList;
    }

    //취소리스트를 설정하는 메서드
    public void setCancelList(int cancelNumber, MenuItem menuItem) {
        cart.set(cancelNumber, menuItem);
    }

    //취소리스트에서 물품을 제거하는 메서드
    public void removeCancelList(int cancelNumber) {
        cancelList.remove(cancelNumber);
    }

    //취소리스트 전체를 출력하는 메서드
    public void printCancelList() {
        System.out.println("[CANCEL]");
        int index = 0;
        for (MenuItem d : cancelList) {
            ++index;
            System.out.println("--------------------");
            System.out.println("[" + index + "]" + " " + d.getName() + " " + d.getPrice() + " " + d.getContents());
        }
        System.out.println("--------------------");
    }

    //취소프로세스1을 출력하는 메서드
    public void printRemoveProcess1() {
        printCart();
        if (getCancelList().isEmpty()) {
            System.out.println("장바구니에서 빼실 품목의 번호를 한 개씩 입력해주세요");
            System.out.println((getCart().size() + 1) + ". 메뉴판   | 메뉴판");
        } else {
            printCancelList();
            if (!getCart().isEmpty()) {
                System.out.println("장바구니에서 빼실 품목의 번호를 한 개씩 입력해주세요");
            }
            System.out.println("장바구니로 되돌리기를 원하실 경우 [CANCEL]품목번호 앞에 -를 붙여 한 개씩 입력해주세요. ex) -1 // -3");
            System.out.println((getCart().size() + 1) + ". 메뉴판    | 메뉴판");
            System.out.println((getCart().size() + 2) + ". 취소하기   | 취소하기");
        }
        System.out.println("0. 종료      | 종료");
    }

    //취소프로세스2를 출력하는 메서드
    public void printRemoveProcess2() {
        printCart();
        if (getCancelList().isEmpty()) {
            System.out.println("장바구니에서 빼실 품목의 번호를 한 개씩 입력해주세요");
            System.out.println((getCart().size() + 1) + ". 이전으로   | 이전으로");
            System.out.println((getCart().size() + 2) + ". 메뉴판    | 메뉴판");
        } else {
            printCancelList();
            if (!getCart().isEmpty()) {
                System.out.println("장바구니에서 빼실 품목의 번호를 한 개씩 입력해주세요");
            }
            System.out.println("장바구니로 되돌리기를 원하실 경우 [CANCEL]품목번호 앞에 -를 붙여 한 개씩 입력해주세요. ex) -1 // -3");
            System.out.println((getCart().size() + 1) + ". 이전으로   | 이전으로");
            System.out.println((getCart().size() + 2) + ". 메뉴판    | 메뉴판");
            System.out.println((getCart().size() + 3) + ". 취소하기   | 취소하기");
        }
        System.out.println("0. 종료      | 종료");
    }
}