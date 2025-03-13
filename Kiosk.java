package kioskassignment;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

import static java.awt.SystemColor.menu;

public class Kiosk {
    //필드에 Menu 객체들을 값으로 하는 리스트 생성
    private List<Menu> categoryList = new ArrayList<>();
    Cart cart = new Cart();
    Order order = new Order();
    Scanner scanner = new Scanner(System.in);

    // categoryList에 Menu 객체들을 추가하는 메서드
    public void addCategory(Menu menu) {
        categoryList.add(menu);
    }

    public void printCategory() {
        int indexMenu = 0;
        for (Menu d : categoryList) {
            ++indexMenu;
            System.out.println(indexMenu + "." + d.getcategoryName());
        }
    }

    public void printCategoryProcess() {
        System.out.println("[MAIN MENU]");
        //향사된 for문에서 index를 활용하기 위해 변수선언
        printCategory();
        if (!cart.getCart().isEmpty()) {
            cart.printCart();
            System.out.print("\n");
            System.out.println("***** 총 주문 예상 금액은 " + cart.getTotalCartPrice() + "원 입니다. *****");
            System.out.print("\n");
            System.out.println((categoryList.size() + 1) + ". Orders    | 장바구니를 확인 후 주문합니다.");
            System.out.println((categoryList.size() + 2) + ". Cancel    | 진행중인 주문을 취소합니다.");
        }
        System.out.println("0. 종료      | 종료");
        System.out.println("원하시는 메뉴의 번호를 입력하세요.");
    }

    public void printMenuItemProcess(int menuNumber) {
        if (cart.getCart().isEmpty()) {
            System.out.println((categoryList.get(menuNumber - 1).getMenuItemList().size() + 1) + ". 처음으로   | 처음으로");
        } else {
            cart.printCart();
            System.out.println("***** 총 주문 예상 금액은 " + cart.getTotalCartPrice() + "원 입니다. *****");
            System.out.println((categoryList.get(menuNumber - 1).getMenuItemList().size() + 1) + ". Orders  | 장바구니를 확인 후 주문합니다.");
            System.out.println((categoryList.get(menuNumber - 1).getMenuItemList().size() + 2) + ". Cancel  | 진행중인 주문을 취소합니다.");
            System.out.println((categoryList.get(menuNumber - 1).getMenuItemList().size() + 3) + ". 처음으로   | 처음으로");
        }
        System.out.println("원하시는 메뉴의 번호를 입력하세요.");
        System.out.println("0. 종료      | 종료");
    }

    public void outputMenuItemList(int menuNumber) throws ArithmeticException {
        if (menuNumber == 0) {
            System.exit(0);
        } else if (menuNumber <= categoryList.size() && menuNumber > 0) {
            categoryList.get(menuNumber - 1).printmenuItemList();
        } else throw new ArithmeticException();
    }

    public void outputIncludeCart(int menuNumber) throws ArithmeticException {
        if (menuNumber <= categoryList.size() && menuNumber > 0) {
            categoryList.get(menuNumber - 1).printmenuItemList();
        } else if (menuNumber == 0) {
            System.exit(0);
        } else if (menuNumber == categoryList.size() + 1) {
            order.addOrderList(cart.getCart());
        } else if (menuNumber == categoryList.size() + 2) {
        } else throw new ArithmeticException();
    }

    public void removeCartMenuItem(int removeNumber) {
        cart.addDeleteList(cart.getCart().get(removeNumber - 1));
        cart.removeCart(removeNumber - 1);
    }

    public void backCartMenuItem(int removeNumber) {
        int index = Math.abs(removeNumber) -1;
        if (index >= 0 && index < cart.getDeleteList().size()) {
            cart.addCart(cart.getDeleteList().get(index));
            cart.removeDeleteList(index);
        } else {
            System.out.println("잘못된 번호입니다");
        }
    }

    public void selectMenuItem(int menuNumber, int menuItemNumber) {
        System.out.println(categoryList.get(menuNumber - 1).getMenuItemList().get(menuItemNumber - 1).getName() + "를 선택하셨습니다.\n" +
                "결제금액은 " + categoryList.get(menuNumber - 1).getMenuItemList().get(menuItemNumber - 1).getPrice() + "원 입니다.");
        cart.addCart(categoryList.get(menuNumber - 1).getMenuItemList().get(menuItemNumber - 1));
    }

    // Kiosk객체 시작 메서드
    public void start() {
        //반복문 시작
        loop:
        while (true) {
            printCategoryProcess();
            //menuItem을 선택하는 반복문에서 category를 선택할때 받은 입력번호를 사용하기위해 변수 선언
            int menuNumber = 0;
            //try - catch 문으로 예외처리
            try {
                //category 선택 번호 입력과 이에 따른 menuItemList 출력과 kiosk 종료
                menuNumber = scanner.nextInt();
                if (cart.getCart().isEmpty()) {
                    outputMenuItemList(menuNumber);
                } else {
                    outputIncludeCart(menuNumber);
                    if (menuNumber == categoryList.size() + 1) {
                        while (true) {
                            order.printOrder();
                            System.out.println("1. 주문      2. 메뉴판");
                            try {
                                int orderInput = scanner.nextInt();
                                if (orderInput == 1) {
                                    System.out.println("주문이 완료되었습니다." + "***** 주문하신 총 금액은 " + order.getTotalOrderPrice() + "원 입니다. *****");
                                    System.out.println("감사합니다. 좋은 하루 보내세요.");
                                    return;
                                } else if (orderInput == 2) {
                                    order.getOrder().clear();
                                    continue loop;
                                } else throw new Exception();
                            } catch (Exception e) {
                                System.out.println("잘못된 번호입니다.");
                                scanner.nextLine();
                            }
                        }
                    } else if (menuNumber == categoryList.size() + 2) {
                        while (true) {
                            cart.printRemoveProcess1();
                            try {
                                int removeNumber = scanner.nextInt();
                                    if (!cart.getDeleteList().isEmpty()) {
                                     if ((removeNumber > 0) && (removeNumber <= cart.getCart().size())) {
                                         removeCartMenuItem(removeNumber);
                                     } else if (removeNumber == 0) {
                                         return;
                                     } else if (removeNumber == (cart.getCart().size() + 1)) {
                                         continue loop;
                                     } else if (removeNumber == (cart.getCart().size() + 2)) {
                                         cart.getDeleteList().clear();
                                         System.out.println("상품이 제거되었습니다.");
                                         continue loop;
                                     } else if (removeNumber < 0 && !cart.getDeleteList().isEmpty() && Math.abs(removeNumber) <= cart.getDeleteList().size()) {
                                             backCartMenuItem(removeNumber);
                                         } else throw new Exception();
                                 } else  {
                                    if ((removeNumber > 0) && (removeNumber <= cart.getCart().size())) {
                                        removeCartMenuItem(removeNumber);
                                    } else if (removeNumber == 0) {
                                        return;
                                    } else if (removeNumber == (cart.getCart().size() + 1)) {
                                        continue loop;
                                    } else throw new Exception();
                                }
                            } catch (Exception e) {
                                System.out.println("잘못된 번호입니다.");
                                scanner.nextLine();
                            }
                        }
                    }
                }
                //메뉴 아이템 선택 구간 nextInt()의 남은 개행 처리
                //menuItem 선택 반복문
                while (true) {
                    printMenuItemProcess(menuNumber);
                    //try - catch 문으로 예외처리
                    try {
                        // menuItem 선택 번호 입력과 이에 따른 이름과 가격 출력, 이전화면으로 이동, Kiosk 종료
                        int menuItemNumber = scanner.nextInt();
                        if (cart.getCart().isEmpty()) {
                            if (menuItemNumber > 0 && menuItemNumber <= categoryList.get(menuNumber - 1).getMenuItemList().size()) {
                                selectMenuItem(menuNumber, menuItemNumber);
                                categoryList.get(menuNumber - 1).printmenuItemList();
                            } else if (menuItemNumber == 0) {
                                return;
                            } else if (menuItemNumber == categoryList.get(menuNumber - 1).getMenuItemList().size() + 1) {
                                continue loop;
                            } else throw new Exception();
                        } else {
                            if (menuItemNumber > 0 && menuItemNumber <= categoryList.get(menuNumber - 1).getMenuItemList().size()) {
                                selectMenuItem(menuNumber, menuItemNumber);
                                categoryList.get(menuNumber - 1).printmenuItemList();
                            } else if (menuItemNumber == 0) {
                                return;
                            } else if (menuItemNumber == categoryList.get(menuNumber - 1).getMenuItemList().size() + 1) {
                                order.addOrderList(cart.getCart());
                                while (true) {
                                    order.printOrder();
                                    System.out.println("1. 주문      2. 메뉴판");
                                    try {
                                        int orderInput = scanner.nextInt();
                                        if (orderInput == 1) {
                                            System.out.println("주문이 완료되었습니다." + "***** 주문하신 총 금액은 " + order.getTotalOrderPrice() + "원 입니다. *****");
                                            System.out.println("감사합니다. 좋은 하루 보내세요.");
                                            return;
                                        } else if (orderInput == 2) {
                                            order.getOrder().clear();
                                            continue loop;
                                        } else throw new Exception();
                                    } catch (Exception e) {
                                        System.out.println("잘못된 번호입니다.");
                                        scanner.nextLine();
                                    }
                                }
                            } else if (menuItemNumber == categoryList.get(menuNumber - 1).getMenuItemList().size() + 2) {
                                while (true) {
                                    cart.printRemoveProcess2();
                                    try {
                                        int removeNumber = scanner.nextInt();
                                        if (!cart.getDeleteList().isEmpty()) {
                                            if ((removeNumber > 0) && (removeNumber <= cart.getCart().size())) {
                                                removeCartMenuItem(removeNumber);
                                            } else if (removeNumber == 0) {
                                                return;
                                            } else if (removeNumber == (cart.getCart().size() + 1)) {
                                                break;
                                            } else if (removeNumber == (cart.getCart().size() + 2)) {
                                                continue loop;
                                            } else if (removeNumber == (cart.getCart().size() + 3)) {
                                                cart.getDeleteList().clear();
                                                System.out.println("상품이 제거되었습니다.");
                                                continue loop;
                                            } else if (removeNumber < 0 && !cart.getDeleteList().isEmpty() && Math.abs(removeNumber) <= cart.getDeleteList().size()) {
                                                backCartMenuItem(removeNumber);
                                            } else throw new Exception();
                                        } else {
                                            if ((removeNumber > 0) && (removeNumber <= cart.getCart().size())) {
                                                removeCartMenuItem(removeNumber);
                                            } else if (removeNumber == 0) {
                                                return;
                                            } else if (removeNumber == (cart.getCart().size() + 1)) {
                                                break;
                                            } else if (removeNumber == (cart.getCart().size() + 2)) {
                                                continue loop;
                                            } else throw new Exception();
                                        }
                                    } catch (Exception e) {
                                        System.out.println("잘못된 번호입니다.");
                                        scanner.nextLine();
                                    }
                                }
                                categoryList.get(menuNumber - 1).printmenuItemList();
                            } else if (menuItemNumber == categoryList.get(menuNumber - 1).getMenuItemList().size() + 3) {
                                continue loop;
                            } else throw new Exception();
                        }
                    } catch (Exception e) {
                        System.out.println("잘못된 번호입니다.");
                        categoryList.get(menuNumber - 1).printmenuItemList();
                        scanner.nextLine();
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