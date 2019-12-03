package camp.nextstep.edu.kitchenpos.model;

public class MenuProductTest {

    public static MenuProduct create(final long productId, final long quantity) {
        final MenuProduct menuProduct = new MenuProduct();
        menuProduct.setProductId(Long.valueOf(productId));
        menuProduct.setQuantity(quantity);
        return menuProduct;
    }
}
