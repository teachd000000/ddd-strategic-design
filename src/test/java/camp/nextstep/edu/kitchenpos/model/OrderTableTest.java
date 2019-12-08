package camp.nextstep.edu.kitchenpos.model;

public class OrderTableTest {

    public static OrderTable create(final Long tableGroupId, final int numberOfGuests) {
        final OrderTable orderTable =  new OrderTable();
        orderTable.setTableGroupId(tableGroupId);
        orderTable.setNumberOfGuests(numberOfGuests);
        orderTable.setEmpty(true);
        return orderTable;
    }

}
