package kioskassignment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Menu {

    private String categoryName;


    private List<MenuItem> menuItemList = new ArrayList<>();


    Menu(String name) {
        this.categoryName = name;
    }

    public String getcategoryName() {
        return this.categoryName;
    }

    public void setCategoryName(String name) {
        this.categoryName = name;
    }

    public void addMenuList(MenuItem menuItem) {
        menuItemList.add(menuItem);
    }

    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    public void setMenuItemList(int setNumber, MenuItem menuItem) {
        menuItemList.set(setNumber, menuItem);
    }

    public int getCategorySize() {
        return menuItemList.size();
    }

    //스트림을 이용해 menuItemList를 전체 출력해주는 메서드
    public void printMenuItemList() {
        //인덱스 사용을 위해 AtomicInteger 객체 생성
        AtomicInteger index = new AtomicInteger(0);
        System.out.println(getcategoryName());
        getMenuItemList().stream().forEach(d -> {
                    //AtomicInteger의 incrementAndGet함수를 이용하여 객체 index의 값을 1 증가시킨 후, 그 증가된 값을 반환
                    int presentIndex = index.incrementAndGet();
                    System.out.println("--------------------");
                    System.out.println(presentIndex + "." + d.getName() + " " + d.getPrice() + " " + d.getContents());
                }
        );
        System.out.println("--------------------");
    }
}
