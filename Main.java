package kioskassignment;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        //Scanner, List 인스턴스화
        Scanner scanner = new Scanner(System.in);
        List<MenuItem> menuItemList = new ArrayList<>();

        //MenuItem 클래스 생성자와 add 함수를 이용하여 리스트에 삽입
        menuItemList.add(new MenuItem("ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItemList.add(new MenuItem("SmokeShack", 8900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItemList.add(new MenuItem("Cheeseburger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItemList.add(new MenuItem("Cheeseburger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));

        //반복문을 통해 리스트 전체 출력
        int index = 0;
        for(MenuItem d : menuItemList) {
            ++index;
            System.out.println("--------------------");
            System.out.println(index + "." + " " + d.getHanmbergerName() + " " + d.getHambergerPrice() + " " + d.getHambergerContent());
        }

        //입력번호를 이용하여 선택 메뉴 출력

        System.out.println("원하시는 메뉴의 번호를 입력하세요");
        try {
            int inputNumber = scanner.nextInt();
            System.out.println((menuItemList.get(inputNumber-1).getHanmbergerName()) + "를 선택하셨습니다.\n" +
                    "결제 금액은 " + menuItemList.get(inputNumber-1).getHambergerPrice() + "원 입니다.\n" +
                    "감사합니다. 좋은 하루 되세요");
        } catch (Exception e) {
            System.out.println("잘못된 번호입니다.");
        }
    }
}