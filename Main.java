package kioskassignment;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("[ SHAKESHACK MENU ]\n" +
                    "1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거\n" +
                    "2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거\n" +
                    "3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거\n" +
                    "4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거\n" +
                    "0. 종료      | 종료");

            try {
                int selectMenu = scanner.nextInt();

                switch (selectMenu) {
                    case 1:
                        System.out.println("ShackBurger를 선택하셨습니다. 감사합니다.");
                        break;
                    case 2:
                        System.out.println("SmokeShack을 선택하셨습니다. 감사합니다.");
                        break;
                    case 3:
                        System.out.println("CheeseBurger를 선택하셨습니다. 감사합니다.");
                        break;
                    case 4:
                        System.out.println("Hamberger를 선택하셨습니다. 감사합니다.");
                        break;
                    case 0:
                        System.out.println("메뉴 선택을 종료합니다. 좋은 하루 보내세요.");
                        return;
                }
            } catch (Exception e) {
                System.out.println("잘못된 번호입니다.");
                scanner.nextLine();
            }
        }
    }
}