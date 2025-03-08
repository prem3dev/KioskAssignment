package kioskassignment;

public class MenuItem {


    //속성
    private String hanmbergerName;
    private Integer hambergerPrice;
    private String hambergerContent;

    MenuItem (String hamberName, Integer hambergerPrice, String hambergerContent){
        this.hanmbergerName = hamberName;
        this.hambergerPrice = hambergerPrice;
        this.hambergerContent = hambergerContent;

    }
    public String getHanmbergerName() {
        return this.hanmbergerName;
    }

    public Integer getHambergerPrice() {
        return this.hambergerPrice;
    }

    public String getHambergerContent() {
        return this.hambergerContent;
    }

    public void setMenuItem(String hambergerName, Integer hambergerPrice, String hambergerContent) {
        this.hanmbergerName = hambergerName;
        this.hambergerPrice = hambergerPrice;
        this.hambergerContent = hambergerContent;
    }
}
