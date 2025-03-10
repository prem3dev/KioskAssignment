package kioskassignment;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    //MenuItem 클래스로 이루어진 리스트 menuItemList 생성

    private List<MenuItem> burger = new ArrayList<>();

    private List<MenuItem> drink = new ArrayList<>();

    private List<MenuItem> dessert = new ArrayList<>();


    public String getFieldMenu1() {
        try {
            return Menu.class.getField(burger.toString()).getName();
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

    }

    public void setBurgerList(MenuItem menuItem) {
        burger.add(menuItem);
    }

    public List<MenuItem> getBurgerList() {
        return burger;
    }

    public void printTotalBurgerList() {
        int index = 0;
        for (MenuItem d : burger) {
            ++index;
            System.out.println("--------------------");
            System.out.println(index + "." + " " + d.getName() + " " + d.getPrice() + " " + d.getContents());
        }
    }

    public String getFieldMenu2() {
        try {
            return Menu.class.getField(drink.toString()).getName();
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

        public void setDrinkList (MenuItem menuItem){
            drink.add(menuItem);
        }

        public List<MenuItem> getDrinkList () {
            return drink;
        }

        public void printTotalDrinkList (){
            int index = 0;
            for (MenuItem d : drink) {
                ++index;
                System.out.println("--------------------");
                System.out.println(index + "." + " " + d.getName() + " " + d.getPrice() + " " + d.getContents());
            }
        }
    public String getFieldMenu3 () {
        try {
            return Menu.class.getField(dessert.toString()).getName();
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

        public void setDessert (MenuItem menuItem){
            dessert.add(menuItem);
        }

        public List<MenuItem> getDessertList () {
            return dessert;
        }

        public void printTotalDessertList (){
            int index = 0;
            for (MenuItem d : dessert) {
                ++index;
                System.out.println("--------------------");
                System.out.println(index + "." + " " + d.getName() + " " + d.getPrice() + " " + d.getContents());
            }
        }
    }
