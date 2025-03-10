package kioskassignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    //MenuItem 클래스로 이루어진 리스트 menuItemList 생성
    private List<MenuItem> menuItemList = new ArrayList<>();

    //Kisok 생성자를 통해 MenuItem 클래스의 데이터 할당과 menuItemList 추가
    Kiosk(List list) {
        menuItemList.addAll(list);
    }

    public void start() {
        //입력번호를 이용하여 선택 메뉴 출력, "0" 입력시 Kiosk 종료
        while (true) {
            //반복문을 통해 리스트 전체 출력
            int index = 0;
            for (MenuItem d : menuItemList) {
                ++index;
                System.out.println("--------------------");
                System.out.println(index + "." + " " + d.getHanmbergerName() + " " + d.getHambergerPrice() + " " + d.getHambergerContents());
            }
            Scanner scanner = new Scanner(System.in);
            System.out.println("원하시는 메뉴의 번호를 입력하세요.(종료를 원하시면 \"0\"을 누르세요.");
            try {
                int inputNumber = scanner.nextInt();
                if (inputNumber == 0) {
                    System.out.println("Kiosk가 종료됩니다.\n" +
                            " 감사합니다. 좋은 하루 되세요");
                    return;
                } else {
                    System.out.println((menuItemList.get(inputNumber - 1).getHanmbergerName()) + "를 선택하셨습니다.\n" +
                            "결제금액은 " + menuItemList.get(inputNumber - 1).getHambergerPrice() + "원 입니다.\n" +
                            "감사합니다. 좋은 하루 되세요");
                }
            } catch (Exception e) {
                System.out.println("잘못된 번호입니다.");
                scanner.nextLine();
            }
        }
    }
}
