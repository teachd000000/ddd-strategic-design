package camp.nextstep.edu.kitchenpos.bo;

import camp.nextstep.edu.kitchenpos.dao.MenuDao;
import camp.nextstep.edu.kitchenpos.dao.MenuGroupDao;
import camp.nextstep.edu.kitchenpos.dao.ProductDao;
import camp.nextstep.edu.kitchenpos.model.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MenuBoTest {

    @Mock
    private MenuDao menuDao;

    @Mock
    private MenuGroupDao menuGroupDao;

    @Mock
    private ProductDao productDao;

    @InjectMocks
    private MenuBo menuBo;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @DisplayName("사용자는 메뉴를 등록할 수 있다")
    @Test
    void 사용자는_메뉴를_등록할_수_있다() {
        // given
        final Menu menu = MenuTest.create(CurrencyHelper.ZERO, 1L);

        // when
        when(menuGroupDao.existsById(anyLong())).thenReturn(true);
        when(menuDao.save(any())).thenReturn(menu);

        // then
        assertThat(menuBo.create(menu))
                .isNotNull();
    }

    @DisplayName("메뉴 가격은 0원 이상이다")
    @Test
    void 메뉴_가격은_0원_이상이다() {
        // given
        final Menu menu = MenuTest.create(CurrencyHelper.NEGATIVE, 1L);

        // when
        // then
        assertThrows(IllegalArgumentException.class, () -> menuBo.create(menu));
    }

    @DisplayName("등록되어 있는 메뉴 그룹 아이디를 가진다")
    @Test
    void 등록되어_있는_메뉴_그룹_아이디를_가진다() {
        // given
        final Menu menu = MenuTest.create(CurrencyHelper.ZERO, 1L);

        // when
        // then
        assertThrows(IllegalArgumentException.class, () -> menuBo.create(menu));
    }

    @DisplayName("메뉴의 가격은 메뉴 상품 목록의 가격 총합보다 클 수 없다")
    @Test
    void 메뉴의_가격은_메뉴_상품_목록의_가격_총합보다_클_수_없다() {
        // given
        final Product product = ProductTest.create(CurrencyHelper.from(400));
        final List<MenuProduct> menuProducts = Arrays.asList(MenuProductTest.create(1, 2));
        final Menu menu = MenuTest.create(CurrencyHelper.ONE_THOUSAND, 1L, menuProducts);

        // when
        when(menuGroupDao.existsById(anyLong())).thenReturn(true);
        when(productDao.findById(anyLong())).thenReturn(Optional.of(product));

        // then
        assertThrows(IllegalArgumentException.class, () -> menuBo.create(menu));
    }

    @DisplayName("사용자는 전체 메뉴 목록를 조회할 수 있다")
    @Test
    void 사용자는_전체_메뉴_목록를_조회할_수_있다() {
        // given
        final List<Menu> menus = Arrays.asList(
                MenuTest.create(CurrencyHelper.ZERO, 1L),
                MenuTest.create(CurrencyHelper.ONE, 1L)
        );

        // when
        when(menuDao.findAll()).thenReturn(menus);

        // then
        assertThat(menuBo.list())
                .isNotNull()
                .hasSize(menus.size());
    }
}
