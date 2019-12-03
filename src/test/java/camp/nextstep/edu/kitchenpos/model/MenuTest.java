package camp.nextstep.edu.kitchenpos.model;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class MenuTest {

    public static Menu create(final BigDecimal price, final Long menuGroupId) {
        final Menu menu =  new Menu();
        menu.setName("menu");
        menu.setPrice(price);
        menu.setMenuGroupId(menuGroupId);
        menu.setMenuProducts(Collections.emptyList());
        return menu;
    }

    public static Menu create(final BigDecimal price, final Long menuGroupId, final List<MenuProduct> menuProducts) {
        final Menu menu =  new Menu();
        menu.setName("menu");
        menu.setPrice(price);
        menu.setMenuGroupId(menuGroupId);
        menu.setMenuProducts(menuProducts);
        return menu;
    }
}
