package kioskassignment;

public class MenuItem {

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

    public void setName(String Name) {
        this.Name = Name;
    }

    public Integer getPrice() {
        return this.Price;
    }

    public void setPrice(Integer Price) {
        this.Price = Price;
    }

    public String getContents() {
        return this.Contents;
    }

    public void setContents(String Contents) {
        this.Contents = Contents;
    }
}
