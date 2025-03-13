package kioskassignment;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Discount {
    NATIONALMERIT(1, "10%", (a) -> (a - (a * 0.1))),
    SOLDIER(2, "5%", (a) -> (a - (a * 0.05))),
    STUDENT(3, "3%", (a) -> (a - (a * 0.03))),
    ORDINARY(4, "0%", (a) -> (a - (a * 0.0)));

    private final Integer code;
    private final String discountPercent;
    private final Function<Integer, Double> discount;

    Discount(Integer code, String discountPercent, Function<Integer, Double> discount) {
        this.code = code;
        this.discountPercent = discountPercent;
        this.discount = discount;
    }

    public static double applyDiscounting(Integer discountNumber, int price) {

        return getDiscount(discountNumber).discount.apply(price);
    }

    public Integer getCode() {
        return this.code;
    }


    public static Discount getDiscount(Integer discountNumber) {
//return 구문이 어떤 용도인지 이해가 안된다. 특히 findfirst부터 올바른 연산자가 아닙니다까지 기재가 없으면 붉은 밑줄이 쳐진다.

        return Arrays.stream(values()).filter(d -> d.getCode() == discountNumber).findFirst().orElse(null);
    }
}
