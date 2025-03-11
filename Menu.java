package kioskassignment;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    //Menu 클래스 속성
    //카테고리 이름 필드 추가
    private String categoryName;

    // MenuItem 클래스를 List로 관리
    private List<MenuItem> menuItemList = new ArrayList<>();

    //Menu 클래스 생성자
    Menu(String name) {
        this.categoryName = name;
    }

    //Menu 클래스 메서드
    //메뉴 카테고리 이름을 반환하는 메서드
    public String getcategoryName() {
        return this.categoryName;
    }

    //menuItemList에 MenuItem 객체를 추가하는 메서드
    public void addMenuList(MenuItem menuItem) {
        menuItemList.add(menuItem);
    }

    //menuItemList를 반환하는 메서드
    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    //menuItemList에 포함된 MenuItem을 순차적으로 보여주는 함수
    public void printmenuItemList() {
        System.out.println("[" + getcategoryName() + " MENU]");
        int index = 0;
        for (MenuItem d : getMenuItemList()) {
            ++index;
            System.out.println("--------------------");
            System.out.println(index + "." + " " + d.getName() + " " + d.getPrice() + " " + d.getContents());
        }
    }
}
