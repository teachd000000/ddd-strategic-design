package camp.nextstep.edu.kitchenpos.bo;

import camp.nextstep.edu.kitchenpos.dao.OrderTableDao;
import camp.nextstep.edu.kitchenpos.model.OrderTable;
import camp.nextstep.edu.kitchenpos.model.OrderTableTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TableBoTest {


    @Mock
    private OrderTableDao orderTableDao;

    @InjectMocks
    private TableBo tableBo;

    @DisplayName("사용자는 주문 테이블을 등록할 수 있다")
    @Test
    void 사용자는_주문_테이블을_등록할_수_있다() {
        // given
        final OrderTable orderTable = OrderTableTest.create(1L, 1);

        // when
        when(orderTableDao.save(any())).thenReturn(orderTable);

        // then
        assertThat(tableBo.create(orderTable))
                .isNotNull();
    }

    @DisplayName("사용자는 전체 주문 테이블 목록을 조회할 수 있다")
    @Test
    void 사용자는_전체_주문_테이블_목록을_조회할_수_있다() {
        // given
        final List<OrderTable> orderTables = Arrays.asList(
                OrderTableTest.create(1L, 1),
                OrderTableTest.create(2L, 1)
        );

        // when
        when(orderTableDao.findAll()).thenReturn(orderTables);

        // then
        assertThat(tableBo.list())
                .isNotNull()
                .hasSize(orderTables.size());
    }

    @DisplayName("사용자는 주문 테이블의 빈 상태로 변경할 수 있다")
    @Test
    void 사용자는_주문_테이블의_빈_상태로_변경할_수_있다() {

    }

    @DisplayName("사용자는 주문 테이블의 인원 수를 변경할 수 있다")
    @Test
    void 사용자는_주문_테이블의_인원_수를_변경할_수_있다() {

    }

}
