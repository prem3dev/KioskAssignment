package kioskassignment;

public class MenuItem {


    //속성
    private String Name;
    private Integer Price;
    private String Contents;

    MenuItem(String Name, Integer Price, String Contents) {
        this.Name = Name;
        this.Price = Price;
        this.Contents = Contents;
    }

    public String getName() {
        return this.Name;
    }

    public Integer getPrice() {
        return this.Price;
    }

    public String getContents() {
        return this.Contents;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setPrice(Integer Price) {
        this.Price = Price;
    }

    public void setContents(String Contents) {
        this.Contents = Contents;
    }
}
