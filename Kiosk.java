package kioskassignment;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    public void start() {
        List<List<MenuItem>> menuList = new ArrayList<>();
        int menuNumber;
        menuList.add(menu.getBurgerList());
        menuList.add(menu.getDrinkList());
        menuList.add(menu.getDessertList());

        System.out.println(menu.getBurgerList());
        //입력번호를 이용하여 선택 메뉴 출력, "0" 입력시 Kiosk 종료
        while (true) {
            Scanner scanner = new Scanner(System.in);
            //반복문을 통해 리스트 전체 출력
            System.out.println("[MAIN MENU]");
            int indexMenu = 0;

            for (List<MenuItem> d : menuList) {
                ++indexMenu;
                System.out.println(indexMenu + "." + d);
            }
            System.out.println("원하시는 메뉴의 번호를 입력하세요." +
                    "(kiosk 종료 - \"0\"번)");
            try {
                menuNumber = scanner.nextInt();
                switch (menuNumber) {
                        case 1 : menu.printTotalBurgerList();
break;
                        case 2 : menu.printTotalDrinkList();
break;
                        case 3 : menu.printTotalDessertList();
break;
                        case 0 : System.out.println("Kiosk가 종료됩니다.\n" +
                                " 감사합니다. 좋은 하루 되세요");
                        return;
                    }
            } catch (Exception e) {
                System.out.println("잘못된 번호입니다.");
                scanner.nextLine();
            }
            scanner.nextLine();
            while (true) {

                System.out.println("원하시는 메뉴의 번호를 입력하세요.\n" +
                        "(kiosk 종료 - \"0\"번)\n" +
                        "(이전화면 - \"9\"번)");
                try {
                    int menuItemNumber = scanner.nextInt();
                    if (menuItemNumber == 0) {
                        System.out.println("Kiosk가 종료됩니다.\n" +
                                " 감사합니다. 좋은 하루 되세요");
                        return;
                    } else if (menuItemNumber == 9) {
                        break;
                    } else {
                        System.out.println(menuList.get(menuItemNumber-1).get(menuItemNumber-1).getName() + "를 선택하셨습니다.\n" +
                                "결제금액은 " + menuList.get(menuItemNumber - 1).get(menuItemNumber-1).getPrice() + "원 입니다.\n" +
                                "감사합니다. 좋은 하루 되세요");
                    }
                } catch (Exception e) {
                    System.out.println("잘못된 번호입니다.");
                    scanner.nextLine();
                }
            }

        }
    }
}
