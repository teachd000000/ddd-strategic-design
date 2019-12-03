package camp.nextstep.edu.kitchenpos.bo;

import camp.nextstep.edu.kitchenpos.dao.ProductDao;
import camp.nextstep.edu.kitchenpos.model.Product;
import camp.nextstep.edu.kitchenpos.model.ProductTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.kitchenpos.model.CommonHelper.toPrice;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductBoTest {

    @Mock
    private ProductDao productDao;

    @InjectMocks
    private ProductBo productBo;

    @DisplayName("사용자는 상품을 등록할 수 있다")
    @Test
    void 사용자는_상품을_등록할_수_있다() {
        // given
        final Product product = ProductTest.create(toPrice(1));

        // when
        when(productDao.save(any())).thenReturn(product);

        // then
        assertThat(productBo.create(product))
                .isNotNull();
    }

    @DisplayName("상품 가격은 0원 이상이다")
    @Test
    void 상품_가격은_0원_이상이다() {
        // given
        final Product product = ProductTest.create(toPrice(-1));

        // when
        // then
        assertThrows(IllegalArgumentException.class, () -> productBo.create(product));
    }

    @DisplayName("사용자는 전체 상품 목록을 조회할 수 있다")
    @Test
    void 사용자는_전체_상품_목록을_조회할_수_있다() {
        // given
        final List<Product> products = Arrays.asList(
                ProductTest.create(toPrice(1)),
                ProductTest.create(toPrice(2))
        );

        // when
        when(productDao.findAll()).thenReturn(products);

        // then
        assertThat(productBo.list())
                .isNotNull()
                .hasSize(products.size());
    }

}
