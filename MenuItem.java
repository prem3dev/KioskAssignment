package kioskassignment;

public class MenuItem {
    //MenuItem 클래스 속성
    // 이름, 가격, 설명 필드 선언
    private String Name;
    private Integer Price;
    private String Contents;

    //MenuItem 클래스 생성자
    MenuItem(String Name, Integer Price, String Contents) {
        this.Name = Name;
        this.Price = Price;
        this.Contents = Contents;
    }

    //MenuItem 클래스 메서드
    //MenuItem 이름을 반환하는 메서드
    public String getName() {
        return this.Name;
    }

    //MenuItem 이름을 설정하는 메서드
    public void setName(String Name) {
        this.Name = Name;
    }

    //MenuItem 가격을 반환하는 메서드
    public Integer getPrice() {
        return this.Price;
    }

    //MenuItem 가격을 설정하는 메서드
    public void setPrice(Integer Price) {
        this.Price = Price;
    }

    //MenuItem 내용을 반환하는 메서드
    public String getContents() {
        return this.Contents;
    }

    //MenuItem 내용을 설정하는 메서드
    public void setContents(String Contents) {
        this.Contents = Contents;
    }
}
