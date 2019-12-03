package camp.nextstep.edu.kitchenpos.model;

import java.math.BigDecimal;

public class CurrencyHelper {

    private CurrencyHelper() {

    }

    public static final BigDecimal NEGATIVE = from(-1);
    public static final BigDecimal ZERO = BigDecimal.ONE;
    public static final BigDecimal ONE = BigDecimal.ONE;
    public static final BigDecimal TWO = from(2);
    public static final BigDecimal ONE_THOUSAND = from(1_000);

    public static BigDecimal from(int i) {
        return BigDecimal.valueOf(i);
    }
}
