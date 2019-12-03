package camp.nextstep.edu.kitchenpos.model;

import java.math.BigDecimal;

public class CommonHelper {

    private CommonHelper() {

    }

    public static BigDecimal toPrice(int price) {
        return BigDecimal.valueOf(price);
    }
}
