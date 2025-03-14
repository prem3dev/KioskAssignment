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

    //카테고리 리스트를 출력해주는 메서드
    public void printCategory() {
        int indexMenu = 0;
        for (Menu d : categoryList) {
            ++indexMenu;
            System.out.println(indexMenu + "." + d.getcategoryName());
        }
    }

    //카테고리 선택 프로세스 출력해주는 메서드
    public void printCategoryProcess() {
        System.out.println("[MAIN MENU]");
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

    //메뉴아이템 선택 프로세스를 출력해주는 메서드
    public void printMenuItemProcess(int menuNumber) {
        if (cart.getCart().isEmpty()) {
            System.out.println((categoryList.get(menuNumber - 1).getMenuItemList().size() + 1) + ". 메뉴판   | 메뉴판");
        } else {
            cart.printCart();
            System.out.println("***** 총 주문 예상 금액은 " + cart.getTotalCartPrice() + "원 입니다. *****");
            System.out.println((categoryList.get(menuNumber - 1).getMenuItemList().size() + 1) + ". Orders  | 장바구니를 확인 후 주문합니다.");
            System.out.println((categoryList.get(menuNumber - 1).getMenuItemList().size() + 2) + ". Cancel  | 진행중인 주문을 취소합니다.");
            System.out.println((categoryList.get(menuNumber - 1).getMenuItemList().size() + 3) + ". 메뉴판   | 메뉴판");
        }
        System.out.println("원하시는 메뉴의 번호를 입력하세요.");
        System.out.println("0. 종료      | 종료");
    }

    //메뉴아이템을 출력해주는 메서드
    public void outputMenuItemList(int menuNumber) throws ArithmeticException {
        if (menuNumber == 0) {
            System.exit(0);
        } else if (menuNumber <= categoryList.size() && menuNumber > 0) {
            categoryList.get(menuNumber - 1).printmenuItemList();
        } else throw new ArithmeticException();
    }

    //장바구니에 물품이 있을 경우 메뉴아이템을 출력해주는 메서드
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

    //장바구니에서 물품을 빼고 취소 리스트에 그 물품을 등록하는 메서드
    public void removeCartMenuItem(int removeNumber) {
        cart.addCancelList(cart.getCart().get(removeNumber - 1));
        cart.removeCart(removeNumber - 1);
    }

    //취소리스트에서 물품을 빼고 장바구니에 그 물품을 등록하는 메서드
    public void backCartMenuItem(int removeNumber) {
        int index = Math.abs(removeNumber) - 1;
        if (index >= 0 && index < cart.getCancelList().size()) {
            cart.addCart(cart.getCancelList().get(index));
            cart.removeCancelList(index);
        } else {
            System.out.println("잘못된 번호입니다");
        }
    }

    // 메뉴아이템을 선택시 이름과 결제 금액을 출력 해주는 메서드
    public void selectMenuItem(int menuNumber, int menuItemNumber) {
        System.out.println(categoryList.get(menuNumber - 1).getMenuItemList().get(menuItemNumber - 1).getName() + "를 선택하셨습니다.\n" +
                "결제금액은 " + categoryList.get(menuNumber - 1).getMenuItemList().get(menuItemNumber - 1).getPrice() + "원 입니다.");
        cart.addCart(categoryList.get(menuNumber - 1).getMenuItemList().get(menuItemNumber - 1));
    }

    // Kiosk객체 시작 메서드
    public void start() {
        //반복문 시작, 루프 생성
        loop:
        while (true) {
            printCategoryProcess();
            //menuItem을 선택하는 반복문에서 category를 선택할때 받은 입력번호를 사용하기위해 변수 선언
            int menuNumber = 0;
            //try - catch 문으로 예외처리
            try {
                //장바구니가 비어있는 경우의 category 선택 번호 입력과 이에 따른 menuItemList 출력, kiosk 종료
                menuNumber = scanner.nextInt();
                if (cart.getCart().isEmpty()) {
                    outputMenuItemList(menuNumber);
                    //그 외 경우의 category 선택 번호 입력과 이에 따른 menuItemList 출력, kiosk 종료, 주문하기, 장바구니 취소
                } else {
                    outputIncludeCart(menuNumber);
                    //주문하기
                    if (menuNumber == categoryList.size() + 1) {
                        //주문하기 반복문
                        while (true) {
                            order.printOrderProcess();
                            System.out.println("1. 주문      2. 메뉴판");
                            try {
                                //주문 선택 번호 입력
                                int orderInput = scanner.nextInt();
                                //주문
                                if (orderInput == 1) {
                                    System.out.println("주문이 완료되었습니다." + "***** 주문하신 총 금액은 " + order.getTotalOrderPrice() + "원 입니다. *****");
                                    System.out.println("감사합니다. 좋은 하루 보내세요.");
                                    return;
                                    //메뉴판으로 돌아가기
                                } else if (orderInput == 2) {
                                    //돌아감으로써 orderList의 데이터 비우기
                                    order.getOrder().clear();
                                    //메뉴판으로 loop
                                    continue loop;
                                } else throw new Exception();
                            } catch (Exception e) {
                                System.out.println("잘못된 번호입니다.");
                                scanner.nextLine();
                            }
                        }
                        //장바구니 취소
                    } else if (menuNumber == categoryList.size() + 2) {
                        //장바구니 취소 반복문
                        while (true) {
                            cart.printRemoveProcess1();
                            try {
                                //장바구니 취소 입력 받기
                                int removeNumber = scanner.nextInt();
                                //취소리스트가 출력된 경우
                                if (!cart.getCancelList().isEmpty()) {
                                    //장바구니에서 물품을 빼고 취소리스트에 추가
                                    if ((removeNumber > 0) && (removeNumber <= cart.getCart().size())) {
                                        removeCartMenuItem(removeNumber);
                                        //Kiosk 종료
                                    } else if (removeNumber == 0) {
                                        return;
                                        //메뉴판으로 돌아가기
                                    } else if (removeNumber == (cart.getCart().size() + 1)) {
                                        continue loop;
                                        //취소리스트에 있는 물품 제거하고 메뉴판으로 돌아가기
                                    } else if (removeNumber == (cart.getCart().size() + 2)) {
                                        cart.getCancelList().clear();
                                        System.out.println("상품이 제거되었습니다.");
                                        continue loop;
                                        // 취소리스트에 있는 물품을 빼고 장바구니에 추가하기
                                    } else if (removeNumber < 0 && !cart.getCancelList().isEmpty() && Math.abs(removeNumber) <= cart.getCancelList().size()) {
                                        backCartMenuItem(removeNumber);
                                    } else throw new Exception();
                                    //취소리스트가 출력되지 않은 경우
                                } else {
                                    //장바구니에서 물품을 빼고 취소리스트에 추가
                                    if ((removeNumber > 0) && (removeNumber <= cart.getCart().size())) {
                                        removeCartMenuItem(removeNumber);
                                        //Kiosk 종료
                                    } else if (removeNumber == 0) {
                                        return;
                                        //메뉴판으로 돌아가기
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
                //menuItem 선택 반복문
                while (true) {
                    printMenuItemProcess(menuNumber);
                    //try - catch 문으로 예외처리
                    try {
                        int menuItemNumber = scanner.nextInt();
                        //장바구니가 비어있는 경우 이에 따른 menuItem 선택과 메뉴판으로 돌아가기, Kiosk 종료
                        if (cart.getCart().isEmpty()) {
                            //메뉴아이템 선택과, 반복을 위한 메뉴아이템리스트 재출력
                            if (menuItemNumber > 0 && menuItemNumber <= categoryList.get(menuNumber - 1).getMenuItemList().size()) {
                                selectMenuItem(menuNumber, menuItemNumber);
                                categoryList.get(menuNumber - 1).printmenuItemList();
                                //Kiosk 종료
                            } else if (menuItemNumber == 0) {
                                return;
                                //메뉴판으로 돌아가기
                            } else if (menuItemNumber == categoryList.get(menuNumber - 1).getMenuItemList().size() + 1) {
                                continue loop;
                            } else throw new Exception();
                            //긔외의 경우 menuItem 선택과 메뉴판으로 돌아가기, Kiosk 종료, 주문하기, 장바구니 취소
                        } else {
                            //menuItem 선택
                            if (menuItemNumber > 0 && menuItemNumber <= categoryList.get(menuNumber - 1).getMenuItemList().size()) {
                                selectMenuItem(menuNumber, menuItemNumber);
                                categoryList.get(menuNumber - 1).printmenuItemList();
                                //Kiosk 종료
                            } else if (menuItemNumber == 0) {
                                return;
                                //주문하기
                            } else if (menuItemNumber == categoryList.get(menuNumber - 1).getMenuItemList().size() + 1) {
                                order.addOrderList(cart.getCart());
                                //주문하기 반복문
                                while (true) {
                                    order.printOrderProcess();
                                    System.out.println("1. 주문      2. 메뉴판");
                                    try {
                                        int orderInput = scanner.nextInt();
                                        //주문
                                        if (orderInput == 1) {
                                            System.out.println("주문이 완료되었습니다." + "***** 주문하신 총 금액은 " + order.getTotalOrderPrice() + "원 입니다. *****");
                                            System.out.println("감사합니다. 좋은 하루 보내세요.");
                                            return;
                                            //메뉴판으로 돌아가기
                                        } else if (orderInput == 2) {
                                            order.getOrder().clear();
                                            continue loop;
                                        } else throw new Exception();
                                    } catch (Exception e) {
                                        System.out.println("잘못된 번호입니다.");
                                        scanner.nextLine();
                                    }
                                }
                                //장바구니 취소
                            } else if (menuItemNumber == categoryList.get(menuNumber - 1).getMenuItemList().size() + 2) {
                                //장바구니 취소 반복문
                                while (true) {
                                    cart.printRemoveProcess2();
                                    try {
                                        int removeNumber = scanner.nextInt();
                                        //취소리스트가 출력된 경우
                                        if (!cart.getCancelList().isEmpty()) {
                                            //장바구니에서 물품을 빼고 취소리스트에 추가
                                            if ((removeNumber > 0) && (removeNumber <= cart.getCart().size())) {
                                                removeCartMenuItem(removeNumber);
                                                //종료
                                            } else if (removeNumber == 0) {
                                                return;
                                                //이전화면으로 돌아가기
                                            } else if (removeNumber == (cart.getCart().size() + 1)) {
                                                break;
                                                //메뉴판으로 돌아가기
                                            } else if (removeNumber == (cart.getCart().size() + 2)) {
                                                continue loop;
                                                //취소리스트에 있는 물품 제거하고 메뉴판으로 돌아가기
                                            } else if (removeNumber == (cart.getCart().size() + 3)) {
                                                cart.getCancelList().clear();
                                                System.out.println("상품이 제거되었습니다.");
                                                continue loop;
                                                // 취소리스트에 있는 물품을 빼고 장바구니에 추가하기
                                            } else if (removeNumber < 0 && !cart.getCancelList().isEmpty() && Math.abs(removeNumber) <= cart.getCancelList().size()) {
                                                backCartMenuItem(removeNumber);
                                            } else throw new Exception();
                                            //취소리스트가 출력되지 않은 경우
                                        } else {
                                            //장바구니에서 물품을 빼고 취소리스트에 추가
                                            if ((removeNumber > 0) && (removeNumber <= cart.getCart().size())) {
                                                removeCartMenuItem(removeNumber);
                                                //종료
                                            } else if (removeNumber == 0) {
                                                return;
                                                //이전화면으로 돌아가기
                                            } else if (removeNumber == (cart.getCart().size() + 1)) {
                                                break;
                                                //메뉴판으로 돌아가기
                                            } else if (removeNumber == (cart.getCart().size() + 2)) {
                                                continue loop;
                                            } else throw new Exception();
                                        }
                                    } catch (Exception e) {
                                        System.out.println("잘못된 번호입니다.");
                                        scanner.nextLine();
                                    }
                                }
                                //장바구니 취소 반복문에서 이전화면으로 나올시 menuItem 출력 반복
                                categoryList.get(menuNumber - 1).printmenuItemList();
                                //메뉴판으로 돌아가기
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