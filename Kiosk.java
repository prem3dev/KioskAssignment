package kioskassignment;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.awt.SystemColor.menu;

public class Kiosk {
    //필드에 Menu 객체들을 값으로 하는 리스트 생성
    private List<Menu> categoryList = new ArrayList<>();

    // categoryList에 Menu 객체들을 추가하는 메서드
    public void addMenu(Menu menu) {
        categoryList.add(menu);
    }

    // Kiosk객체 시작 메서드
    public void start() {
        //반복문 시작
        while (true) {
            //스캐너 선언
            Scanner scanner = new Scanner(System.in);
            //향상된 for문을 통해 categoryList 전체 출력
            System.out.println("[MAIN MENU]");
            //향사된 for문에서 index를 활용하기 위해 변수선언
            int indexMenu = 0;

            for (Menu d : categoryList) {
                ++indexMenu;
                System.out.println(indexMenu + "." + d.getcategoryName());
            }
            System.out.println("원하시는 메뉴의 번호를 입력하세요.\n" +
                    "(Kiosk 종료 - \"0\"번)");
            //menuItem을 선택하는 반복문에서 category를 선택할때 받은 입력번호를 사용하기위해 변수 선언
            int menuNumber = 0;
            //try - catch 문으로 예외처리
            try {
                //category 선택 번호 입력과 이에 따른 menuItemList 출력과 kiosk 종료
                menuNumber = scanner.nextInt();
                switch (menuNumber) {
                    case 1:
                        categoryList.get(menuNumber - 1).printmenuItemList();

                        break;
                    case 2:
                        categoryList.get(menuNumber - 1).printmenuItemList();
                        break;
                    case 3:
                        categoryList.get(menuNumber - 1).printmenuItemList();
                        break;
                    case 0:
                        System.out.println("Kiosk가 종료됩니다.\n" +
                                " 감사합니다. 좋은 하루 되세요");
                        return;
                }
                //nextInt()의 남은 개행 처리
                scanner.nextLine();
                //menuItem 선택 반복문
                while (true) {

                    System.out.println("원하시는 메뉴의 번호를 입력하세요.\n" +
                            "(Kiosk 종료 - \"0\"번)\n" +
                            "(이전화면 - \"9\"번)");
                    //try - catch 문으로 예외처리
                    try {
                        // menuItem 선택 번호 입력과 이에 따른 이름과 가격 출력, 이전화면으로 이동, Kiosk 종료
                        int menuItemNumber = scanner.nextInt();
                        if (menuItemNumber == 0) {
                            System.out.println("Kiosk가 종료됩니다.\n" +
                                    " 감사합니다. 좋은 하루 되세요");
                            return;
                        } else if (menuItemNumber == 9) {
                            break;
                        } else {
                            System.out.println(categoryList.get(menuNumber - 1).getMenuItemList().get(menuItemNumber - 1).getName() + "를 선택하셨습니다.\n" +
                                    "결제금액은 " + categoryList.get(menuNumber - 1).getMenuItemList().get(menuItemNumber - 1).getPrice() + "원 입니다.\n" +
                                    "감사합니다. 좋은 하루 되세요");
                            categoryList.get(menuNumber - 1).printmenuItemList();
                        }
                    } catch (Exception e) {
                        System.out.println("잘못된 번호입니다.");
                        scanner.nextLine();
                        categoryList.get(menuNumber - 1).printmenuItemList();
                    }
                }
            } catch (Exception e) {
                System.out.println("잘못된 번호입니다.");
                //nextInt()의 남은 개행 처리
                scanner.nextLine();
            }
        }
    }
}