package kioskassignment;

public class MenuItem {


    //속성
    private String hanmbergerName;
    private Integer hambergerPrice;
    private String hambergerContents;

    MenuItem(String hamberName, Integer hambergerPrice, String hambergerContents) {
        this.hanmbergerName = hamberName;
        this.hambergerPrice = hambergerPrice;
        this.hambergerContents = hambergerContents;
    }

    public String getHanmbergerName() {
        return this.hanmbergerName;
    }

    public Integer getHambergerPrice() {
        return this.hambergerPrice;
    }

    public String getHambergerContents() {
        return this.hambergerContents;
    }

    public void setMenuItem(String hambergerName, Integer hambergerPrice, String hambergerContents) {
        this.hanmbergerName = hambergerName;
        this.hambergerPrice = hambergerPrice;
        this.hambergerContents = hambergerContents;
    }
}
