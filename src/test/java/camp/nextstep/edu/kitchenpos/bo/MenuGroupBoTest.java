package camp.nextstep.edu.kitchenpos.bo;

import camp.nextstep.edu.kitchenpos.dao.MenuGroupDao;
import camp.nextstep.edu.kitchenpos.model.MenuGroup;
import camp.nextstep.edu.kitchenpos.model.MenuGroupTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MenuGroupBoTest {

    @Mock
    private MenuGroupDao menuGroupDao;

    @InjectMocks
    private MenuGroupBo menuGroupBo;

    @DisplayName("사용자는 메뉴 그룹을 등록할 수 있다")
    @Test
    void 사용자는_메뉴_그룹을_등록할_수_있다() {
        // given
        final MenuGroup menuGroup = MenuGroupTest.create();

        // when
        when(menuGroupDao.save(any())).thenReturn(menuGroup);

        // then
        assertThat(menuGroupBo.create(menuGroup))
                .isNotNull();
    }

    @DisplayName("사용자는 전체 메뉴 그룹 목록을 조회할 수 있다")
    @Test
    void 사용자는_전체_메뉴_그룹_목록을_조회할_수_있다() {
        // given
        final List<MenuGroup> menuGroups = Arrays.asList(
                MenuGroupTest.create(),
                MenuGroupTest.create()
        );

        // when
        when(menuGroupDao.findAll()).thenReturn(menuGroups);

        // then
        assertThat(menuGroupBo.list())
                .isNotNull()
                .hasSize(menuGroups.size());
    }
}
