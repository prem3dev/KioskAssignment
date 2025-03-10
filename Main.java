package kioskassignment;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;;

public class Main {

    public static void main(String[] args) {
        //MenItem을 새로 추가하는 리스트을 생성, MenuItem 데이터 추가
        List<MenuItem> addMeuItemList = new ArrayList<>();
        addMeuItemList.add(new MenuItem("ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        addMeuItemList.add(new MenuItem("Smokeshack", 8900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        addMeuItemList.add(new MenuItem("CheeseBurger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        addMeuItemList.add(new MenuItem("HamBurger", 5400, "비프패티를 기반으로 야채가 들어간 기본버거"));
        //Kiosk 클래스 생성자를 이용하여 MenuItem추가리스트를 MenuItemList에 추가
        Kiosk kiosk = new Kiosk(addMeuItemList);

        kiosk.start();
    }
}