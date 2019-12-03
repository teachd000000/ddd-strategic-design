package camp.nextstep.edu.kitchenpos.model;

import java.math.BigDecimal;

public class ProductTest {

    public static Product create(final BigDecimal price) {
        final Product product =  new Product();
        product.setName("product");
        product.setPrice(price);
        return product;
    }
}
