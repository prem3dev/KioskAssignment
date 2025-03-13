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

    //메서드 : 각각 Hamburger 이름과 가격 설명을 반환하는 게터들 / 동일한 요소를 설정하는 세터들
    public String getHamburgerName() {
        return this.hamburgerName;
    }

    public Integer getHamburgerPrice() {
        return this.hamburgerPrice;
    }

    public String getHamburgerContents() {
        return this.getHamburgerContents();
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