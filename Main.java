package kioskassignment;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;;

public class Main {

    public static void main(String[] args) {

        Menu burgers = new Menu("BURGERS");
        Menu drinks = new Menu("DRINKS");
        Menu desserts = new Menu("DESSERTS");

        burgers.addMenuList(new MenuItem("ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgers.addMenuList(new MenuItem("Smokeshack", 8900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgers.addMenuList(new MenuItem("CheeseBurger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgers.addMenuList(new MenuItem("HamBurger", 5400, "비프패티를 기반으로 야채가 들어간 기본버거"));
        drinks.addMenuList(new MenuItem("Coke", 1500, "시원한 콜라"));
        drinks.addMenuList(new MenuItem("Juice", 1800, "시원한 쥬스"));
        desserts.addMenuList(new MenuItem("FrenchFry", 2200, "짭잘한 감자튀김"));
        desserts.addMenuList(new MenuItem("iceCream", 2000, "시원한 바닐라 아이스크림"));

        Kiosk kiosk = new Kiosk();

        kiosk.addCategory(burgers);
        kiosk.addCategory(drinks);
        kiosk.addCategory(desserts);
        kiosk.start();
    }
}
