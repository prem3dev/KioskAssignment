package kioskassignment;

import javax.lang.model.type.ArrayType;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.awt.SystemColor.menu;

public class Kiosk {

    private List<Menu> categoryList = new ArrayList<>();
    Cart cart = new Cart();
    Order order = new Order();
    Scanner scanner = new Scanner(System.in);

    public void addCategory(Menu menu) {
        categoryList.add(menu);
    }

    //스트림을 이용해 카테고리리스트를 전체 출력해주는 메서드
    public void printCategory() {
        //인덱스 사용을 위해 AtomicInteger 객체 생성
        AtomicInteger indexCategory = new AtomicInteger(0);
        System.out.println("[MAIN MENU]");
        categoryList.stream().forEach(d -> {
                    //AtomicInteger의 incrementAndGet함수를 이용하여 객체 index의 값을 1 증가시킨 후, 그 증가된 값을 반환
                    int currentIndex = indexCategory.incrementAndGet();
                    System.out.println("--------------------");
                    System.out.println(currentIndex + "." + d.getcategoryName());
                }
        );
        System.out.println("--------------------");
    }

    public void printCategoryProcess() {
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
            categoryList.get(menuNumber - 1).printMenuItemList();
        } else throw new ArithmeticException();
    }

    public void outputIncludeCart(int menuNumber) throws ArithmeticException {
        if (menuNumber <= categoryList.size() && menuNumber > 0) {
            categoryList.get(menuNumber - 1).printMenuItemList();
        } else if (menuNumber == 0) {
            System.exit(0);
        } else if (menuNumber == categoryList.size() + 1) {
            order.addOrderList(cart.getCart());
        } else if (menuNumber == categoryList.size() + 2) {
        } else throw new ArithmeticException();
    }

    public void cancelCartMenuItem(int cancelNumber) throws Exception {
        int index = cancelNumber - 1;
        if (index >= 0 && index < cart.getCart().size()) {
            cart.addCancelList(cart.getCart().stream().filter(d -> d.equals(cart.getCart().get(index))).findFirst().orElse(null));
            cart.removeCart(cart.getCart().stream().filter(d -> d.equals(cart.getCart().get(index))).findFirst().orElse(null));
        } else throw new Exception();
    }

    public void backCartMenuItem(int cancelNumber) {
        int index = Math.abs(cancelNumber) - 1;
        if (index >= 0 && index < cart.getCancelList().size()) {
            cart.addCart(cart.getCancelList().stream().filter(d -> d.equals(cart.getCancelList().get(index))).findFirst().orElse(null));
            cart.removeCancelList(cart.getCancelList().stream().filter(d -> d.equals(cart.getCancelList().get(index))).findFirst().orElse(null));
        } else {
            System.out.println("잘못된 번호입니다");
        }
    }

    public void selectMenuItem(int menuNumber, int menuItemNumber) {
        System.out.println(categoryList.get(menuNumber - 1).getMenuItemList().get(menuItemNumber - 1).getName() + "를 선택하셨습니다.\n" +
                "결제금액은 " + categoryList.get(menuNumber - 1).getMenuItemList().get(menuItemNumber - 1).getPrice() + "원 입니다.");
        cart.addCart(categoryList.get(menuNumber - 1).getMenuItemList().get(menuItemNumber - 1));
    }

    //할인이 적용된 주문 프로세스를 출력해주는 메서드
    public void printDiscountedOrderProcess() {
        while (true) {
            System.out.println("할인 정보를 입력해 주세요");
            System.out.println("1. 국가유공자 : 10% \n" +
                    "2. 군인     :  5%\n" +
                    "3. 학생     :  3%\n" +
                    "4. 일반     :  0%");
            try {
                int discountInputNumber = scanner.nextInt();
                if (discountInputNumber > 0 && discountInputNumber <= 4) {
                    //applyDiscounting 함수의 반환 값이 double이기 때문에(할인율이 실수) 소수점 아래를 출력시키지 않기 위해 int로 형 변환
                    int discoutedNumber = (int) Discount.applyDiscounting(discountInputNumber, (order.getTotalOrderPrice()));
                    System.out.println("주문이 완료되었습니다." + "***** 주문하신 총 금액은 " + discoutedNumber + "원 입니다. *****");
                    System.out.println("감사합니다. 좋은 하루 보내세요.");
                    //주문 후 Kiosk 종료
                    System.exit(0);
                } else throw new Exception();
            } catch (Exception e) {
                System.out.println("잘못된 번호입니다.");
                scanner.nextLine();
            }
        }
    }

    public void start() {
        //카테고리 선택
        loop:
        while (true) {
            //카테고리 프로세스 출력 <= 카테고리 리스트, 장바구니 스트림
            printCategoryProcess();
            int menuNumber = 0;
            try {
                menuNumber = scanner.nextInt();
                //장바구니가 비어있을 경우
                if (cart.getCart().isEmpty()) {
                    //메뉴아이템 리스트 등을 출력 <= 스트림
                    outputMenuItemList(menuNumber);
                } else {
                    //장바구니가 비어있지 않을 경우
                    //메뉴아이템 리스트 등을 출력 <= 스트림
                    outputIncludeCart(menuNumber);
                    //주문
                    if (menuNumber == categoryList.size() + 1) {
                        while (true) {
                            order.printOrder();
                            System.out.println("1. 주문      2. 메뉴판");
                            try {
                                int orderInput = scanner.nextInt();
                                if (orderInput == 1) {
                                    //Discount Enum을 활용하여 할인된 주문 프로세스 출력
                                    printDiscountedOrderProcess();
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
                    } else if (menuNumber == categoryList.size() + 2) {
                        while (true) {
                            //취소프로세스 출력 <= 장바구니, 취소리스트 스트림
                            cart.printCancelProcess1();
                            try {
                                int cancelNumber = scanner.nextInt();
                                //취소리스트가 비어있지 않았을 경우
                                if (!cart.getCancelList().isEmpty()) {
                                    if ((cancelNumber > 0) && (cancelNumber <= cart.getCart().size())) {
                                        cancelCartMenuItem(cancelNumber);
                                    } else if (cancelNumber == 0) {
                                        return;
                                    } else if (cancelNumber == (cart.getCart().size() + 1)) {
                                        continue loop;
                                    } else if (cancelNumber == (cart.getCart().size() + 2)) {
                                        cart.getCancelList().clear();
                                        System.out.println("상품이 제거되었습니다.");
                                        continue loop;
                                    } else if (cancelNumber < 0 && Math.abs(cancelNumber) <= cart.getCancelList().size()) {
                                        backCartMenuItem(cancelNumber);
                                    } else throw new Exception();
                                    //취소리스트가 비어있을 경우
                                } else {
                                    if ((cancelNumber > 0) && (cancelNumber <= cart.getCart().size())) {
                                        cancelCartMenuItem(cancelNumber);
                                    } else if (cancelNumber == 0) {
                                        return;
                                    } else if (cancelNumber == (cart.getCart().size() + 1)) {
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
                //menuItem 선택
                while (true) {
                    printMenuItemProcess(menuNumber);
                    try {
                        int menuItemNumber = scanner.nextInt();
                        //장바구니가 비어있을 경우
                        if (cart.getCart().isEmpty()) {
                            if (menuItemNumber > 0 && menuItemNumber <= categoryList.get(menuNumber - 1).getMenuItemList().size()) {
                                selectMenuItem(menuNumber, menuItemNumber);
                                categoryList.get(menuNumber - 1).printMenuItemList();
                            } else if (menuItemNumber == 0) {
                                return;
                            } else if (menuItemNumber == categoryList.get(menuNumber - 1).getMenuItemList().size() + 1) {
                                continue loop;
                            } else throw new Exception();
                            //장바구니가 비어있지 않을 경우
                        } else {
                            if (menuItemNumber > 0 && menuItemNumber <= categoryList.get(menuNumber - 1).getMenuItemList().size()) {
                                selectMenuItem(menuNumber, menuItemNumber);
                                categoryList.get(menuNumber - 1).printMenuItemList();
                            } else if (menuItemNumber == 0) {
                                return;
                                //주문
                            } else if (menuItemNumber == categoryList.get(menuNumber - 1).getMenuItemList().size() + 1) {
                                order.addOrderList(cart.getCart());
                                while (true) {
                                    order.printOrder();
                                    System.out.println("1. 주문      2. 메뉴판");
                                    try {
                                        int orderInput = scanner.nextInt();
                                        if (orderInput == 1) {
                                            //Discount Enum을 활용하여 할인된 주문 프로세스 출력
                                            printDiscountedOrderProcess();
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
                                while (true) {
                                    //취소프로스세스 출력 <= 장바구니, 취소리스트 스트림
                                    cart.printCancelProcess2();
                                    try {
                                        int cancelNumber = scanner.nextInt();
                                        //취소리스트가 비어있지 않았을 경우
                                        if (!cart.getCancelList().isEmpty()) {
                                            if ((cancelNumber > 0) && (cancelNumber <= cart.getCart().size())) {
                                                cancelCartMenuItem(cancelNumber);
                                            } else if (cancelNumber == 0) {
                                                return;
                                            } else if (cancelNumber == (cart.getCart().size() + 1)) {
                                                break;
                                            } else if (cancelNumber == (cart.getCart().size() + 2)) {
                                                continue loop;
                                            } else if (cancelNumber == (cart.getCart().size() + 3)) {
                                                cart.getCancelList().clear();
                                                System.out.println("상품이 제거되었습니다.");
                                                continue loop;
                                            } else if (cancelNumber < 0 && Math.abs(cancelNumber) <= cart.getCancelList().size()) {
                                                backCartMenuItem(cancelNumber);
                                            } else throw new Exception();
                                            //취소리스트가 비어있을 경우
                                        } else {
                                            if ((cancelNumber > 0) && (cancelNumber <= cart.getCart().size())) {
                                                cancelCartMenuItem(cancelNumber);
                                            } else if (cancelNumber == 0) {
                                                return;
                                            } else if (cancelNumber == (cart.getCart().size() + 1)) {
                                                break;
                                            } else if (cancelNumber == (cart.getCart().size() + 2)) {
                                                continue loop;
                                            } else throw new Exception();
                                        }
                                    } catch (Exception e) {
                                        System.out.println("잘못된 번호입니다.");
                                        scanner.nextLine();
                                    }
                                }
                                categoryList.get(menuNumber - 1).printMenuItemList();
                            } else if (menuItemNumber == categoryList.get(menuNumber - 1).getMenuItemList().size() + 3) {
                                continue loop;
                            } else throw new Exception();
                        }
                    } catch (Exception e) {
                        System.out.println("잘못된 번호입니다.");
                        categoryList.get(menuNumber - 1).printMenuItemList();
                        scanner.nextLine();
                    }
                }
            } catch (Exception e) {
                System.out.println("잘못된 번호입니다.");
                scanner.nextLine();
            }
        }
    }
}