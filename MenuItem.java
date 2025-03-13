package kioskassignment;

public class MenuItem {

    //속성
    private String hamburgerName;
    private Integer hamburgerPrice;
    private String hamburgerContents;

    //생성자
    MenuItem(String hamburgerName, Integer hamburgerPrice, String hamburgerContents) {
        this.hamburgerName = hamburgerName;
        this.hamburgerPrice = hamburgerPrice;
        this.hamburgerContents = hamburgerContents;
    }

    //메서드
    public String getHamburgerName() {
        return this.hamburgerName;
    }

    public Integer getHamburgerPrice() {
        return this.hamburgerPrice;
    }

    public String getHamburgerContents() {
        return this.hamburgerContents;
    }

    public void setHamburgerName(String hamburgerName) {
        this.hamburgerName = hamburgerName;
    }

    public void setHamburgerPrice(Integer hamburgerPrice) {
        this.hamburgerPrice = hamburgerPrice;
    }

    public void setHamburgerContents(String hamburgerContents) {
        this.hamburgerContents = hamburgerContents;
    }
}
