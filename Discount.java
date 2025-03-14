package kioskassignment;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

//각각 코드번호, 할인률, 할인함수를 속성으로 가지는 상수 나열
public enum Discount {
    NATIONALMERIT(1, "10%", (a) -> (a - (a * 0.1))),
    SOLDIER(2, "5%", (a) -> (a - (a * 0.05))),
    STUDENT(3, "3%", (a) -> (a - (a * 0.03))),
    ORDINARY(4, "0%", (a) -> (a - (a * 0.0)));
    //상수 속성
    private final Integer code;
    private final String discountPercent;
    private final Function<Integer, Double> discount;

    //상수 생성자
    Discount(Integer code, String discountPercent, Function<Integer, Double> discount) {
        this.code = code;
        this.discountPercent = discountPercent;
        this.discount = discount;
    }

    //매개변수인 정수와 가격에 따른 할인 가격을 반환하는 메서드
    public static double applyDiscounting(Integer discountNumber, Integer price) {

        return getDiscount(discountNumber).discount.apply(price);
    }

    //상수의 코드를 반환하는 메서드
    public Integer getCode() {
        return this.code;
    }

    //매개변수인 정수에 따라 이넘 상수 클래스를 반환하는 메서드
    public static Discount getDiscount(Integer discountNumber) {
        return Arrays.stream(values()).filter(d -> d.getCode() == discountNumber).findFirst().orElse(null);
    }
}
