package kioskassignment;

import javax.swing.border.Border;
import java.util.ArrayList;
import java.util.List;

public class Order {
    //속성
    private List<MenuItem> order = new ArrayList<>();

    //메서드
    //주문리스트에 리스트를 추가하는 메서드
    public void addOrderList(List<MenuItem> cart) {
        order.addAll(cart);
    }

    //주문리스트를 반환하는 메서드
    public List<MenuItem> getOrder() {
        return this.order;
    }

    //주문리스트를 설정하는 메서드
    public void setOrder(int orderNumber, MenuItem menuItem) {
        order.set(orderNumber, menuItem);
    }

    //주문 프로세스를 출력하는 메서드
    public void printOrderProcess() {
        System.out.println("[ORDERS]");
        if (getOrder().size() - 1 == 0) {
            System.out.println("\"" + order.get(0).getName() + "\"" + "상품을 구매하시겠습니까?");
        } else {
            System.out.println("\"" + order.get(0).getName() + "\"" + " 외 " + (order.size() - 1) + "개의 상품을 구매하시겠습니까?");
        }
        System.out.println("--------------------");
        System.out.println("[TOTAL]");
        System.out.println(getTotalOrderPrice() + "원");
        System.out.println("--------------------");
    }

    //주문리스트 전체 가격의 합을 반환하는 메서드
    public Integer getTotalOrderPrice() {
        Integer totalOrderPrice = 0;
        for (MenuItem d : getOrder()) {
            totalOrderPrice += d.getPrice();
        }
        return totalOrderPrice;
    }
}