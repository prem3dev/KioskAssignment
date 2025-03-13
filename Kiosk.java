package kioskassignment;

import jdk.jfr.Category;

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
                System.out.println(indexMenu + "." + d.getCategoryName());
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
                        categoryList.get(menuNumber - 1).printMenuItemList();

                        break;
                    case 2:
                        categoryList.get(menuNumber - 1).printMenuItemList();
                        break;
                    case 3:
                        categoryList.get(menuNumber - 1).printMenuItemList();
                        break;
                    case 0:
                        System.out.println("Kiosk가 종료됩니다.\n" +
                                " 감사합니다. 좋은 하루 되세요");
                        return;
                }
                scanner.nextLine();
                //menuItem 선택 반복문
                while (true) {

                    System.out.println("원하시는 메뉴의 번호를 입력하세요.\n" +
                            "(Kiosk 종료 - \"0\"번)\n" +
                            "(이전화면 - \"" + ((categoryList.get(menuNumber-1).getMenuItemList().size()) + 1) + "\"번)");
                    //try - catch 문으로 예외처리
                    try {
                        // menuItem 선택 번호 입력과 이에 따른 이름과 가격 출력, 이전화면으로 이동, Kiosk 종료
                        int menuItemNumber = scanner.nextInt();
                        // 0일 경우 종료
                        if (menuItemNumber == 0) {
                            System.out.println("Kiosk가 종료됩니다.\n" +
                                    " 감사합니다. 좋은 하루 되세요");
                            return;
                            // 인덱스 수보다 1이 클 경우 이전화면
                        } else if (menuItemNumber == (categoryList.get(menuNumber-1).getMenuItemList().size()) + 1) {
                            break;
                            // 0보다 크고 인덱스 수보다 작거나 같으면 주문 출력
                        } else if (menuItemNumber > 0 && menuItemNumber <= categoryList.get(menuNumber-1).getMenuItemList().size()){
                            System.out.println(categoryList.get(menuNumber - 1).getMenuItemList().get(menuItemNumber - 1).getName() + "를 선택하셨습니다.\n" +
                                    "결제 금액은 " + categoryList.get(menuNumber - 1).getMenuItemList().get(menuItemNumber - 1).getPrice() + "원 입니다.\n" +
                                    "감사합니다. 좋은 하루 되세요");
                            //반복을 위해 menuItem 리스트 재출력
                            categoryList.get(menuNumber - 1).printMenuItemList();
                        //그 외는 예외 강제 발생
                        } else throw new Exception();
                    } catch (Exception e) {
                        System.out.println("잘못된 번호입니다.");
                        scanner.nextLine();
                        //catch로 인한 예외 이후에도 반복을 위해 menuItem 리스트 재출력
                        categoryList.get(menuNumber - 1).printMenuItemList();
                    }
                }
            } catch (Exception e) {
                System.out.println("잘못된 번호입니다.");
                scanner.nextLine();
            }
        }
    }
}