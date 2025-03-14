package kioskassignment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Cart {
    private List<MenuItem> cart = new ArrayList<>();
    private List<MenuItem> cancelList = new ArrayList<>();

    public void addCart(MenuItem menuItem) {
        cart.add(menuItem);
    }

    public List<MenuItem> getCart() {
        return this.cart;
    }

    public void setCart(int cartNumber, MenuItem menuItem) {
        cart.set(cartNumber, menuItem);
    }

    public void removeCart(MenuItem menuItem) {
        cart.remove(menuItem);
    }

    //스트림을 이용해 장바구니리스트를 전체 출력해주는 메서드
    public void printCart() {
        //인덱스 사용을 위해 AtomicInteger 객체 생성
        AtomicInteger index = new AtomicInteger(0);
        System.out.println("[CART]");
        getCart().stream().forEach(d -> {
                    //AtomicInteger의 incrementAndGet함수를 이용하여 객체 index의 값을 1 증가시킨 후, 그 증가된 값을 반환
                    int presentIndex = index.incrementAndGet();
                    System.out.println("--------------------");
                    System.out.println(presentIndex + "." + d.getName() + " " + d.getPrice() + " " + d.getContents());
                }
        );
        System.out.println("--------------------");
    }


    public Integer getTotalCartPrice() {
        Integer totalCartPrice = 0;
        for (MenuItem d : getCart()) {
            totalCartPrice += d.getPrice();
        }
        return totalCartPrice;
    }

    public void addCancelList(MenuItem menuItem) {
        cancelList.add(menuItem);
    }

    public List<MenuItem> getCancelList() {
        return this.cancelList;
    }

    public void setCancelList(int cancelNumber, MenuItem menuItem) {
        cart.set(cancelNumber, menuItem);
    }

    public void removeCancelList(MenuItem menuItem) {
        cancelList.remove(menuItem);
    }

    //스트림을 이용해 취소리스트를 전체 출력해주는 메서드
    public void printCancelList() {
        //인덱스 사용을 위해 AtomicInteger 객체 생성
        AtomicInteger index = new AtomicInteger(0);
        System.out.println("[CANCEL]");
        getCancelList().stream().forEach(d -> {
                    //AtomicInteger의 incrementAndGet함수를 이용하여 객체 index의 값을 1 증가시킨 후, 그 증가된 값을 반환
                    int presentIndex = index.incrementAndGet();
                    System.out.println("--------------------");
                    System.out.println(presentIndex + "." + d.getName() + " " + d.getPrice() + " " + d.getContents());
                }
        );
        System.out.println("--------------------");
    }

    public void printCancelProcess1() {
        printCart();
        if (getCancelList().isEmpty()) {
            System.out.println("장바구니에서 빼실 품목의 번호를 한 개씩 입력해주세요");
            System.out.println((getCart().size() + 1) + ". 처음으로   | 처음으로");
        } else {
            printCancelList();
            if (!getCart().isEmpty()) {
                System.out.println("장바구니에서 빼실 품목의 번호를 한 개씩 입력해주세요");
            }
            System.out.println("장바구니로 되돌리기를 원하실 경우 [CANCEL]품목번호 앞에 -를 붙여 한 개씩 입력해주세요. ex) -1 // -3");
            System.out.println((getCart().size() + 1) + ". 처음으로   | 처음으로");
            System.out.println((getCart().size() + 2) + ". 취소하기   | 취소하기");
        }
        System.out.println("0. 종료      | 종료");
    }

    public void printCancelProcess2() {
        printCart();
        if (getCancelList().isEmpty()) {
            System.out.println("장바구니에서 빼실 품목의 번호를 한 개씩 입력해주세요");
            System.out.println((getCart().size() + 1) + ". 이전으로   | 이전으로");
            System.out.println((getCart().size() + 2) + ". 처음으로   | 처음으로");
        } else {
            printCancelList();
            if (!getCart().isEmpty()) {
                System.out.println("장바구니에서 빼실 품목의 번호를 한 개씩 입력해주세요");
            }
            System.out.println("장바구니로 되돌리기를 원하실 경우 [CANCEL]품목번호 앞에 -를 붙여 한 개씩 입력해주세요. ex) -1 // -3");
            System.out.println((getCart().size() + 1) + ". 이전으로   | 이전으로");
            System.out.println((getCart().size() + 2) + ". 처음으로   | 처음으로");
            System.out.println((getCart().size() + 3) + ". 취소하기   | 취소하기");
        }
        System.out.println("0. 종료      | 종료");
    }
}