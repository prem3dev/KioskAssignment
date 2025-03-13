package kioskassignment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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
    //카테고리 이름을 반환하는 메서드
    public String getcategoryName() {
        return this.categoryName;
    }

    //카테고리 이름을 설정하는 메서드
    public void setCategoryName(String name) {
        this.categoryName = name;
    }


    //menuItemList에 MenuItem 객체를 추가하는 메서드
    public void addMenuList(MenuItem menuItem) {
        menuItemList.add(menuItem);
    }

    //menuItemList를 반환하는 메서드
    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    //menuItemList를 설정하는 메서드
    public void setMenuItemList(int setNumber, MenuItem menuItem) {
        menuItemList.set(setNumber, menuItem);
    }

    public int getCategorySize() {
        return menuItemList.size();
    }

    //menuItemList에 포함된 MenuItem을 순차적으로 보여주는 함수

    public void printMenuItemList() {
        AtomicInteger index = new AtomicInteger(0);
        System.out.println(getcategoryName());
        getMenuItemList().stream().forEach(d -> {
                    int presentIndex = index.incrementAndGet();
                    System.out.println("--------------------");
                    System.out.println(presentIndex + "." + d.getName() + " " + d.getPrice() + " " + d.getContents());
                }
        );
        System.out.println("--------------------");
    }
}
