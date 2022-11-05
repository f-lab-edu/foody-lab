package app.foodylab;

import app.foodylab.domain.order.Order;
import java.time.LocalDate;

public class OrderFixture {

    private OrderFixture() {
    }

    public static Order DUMMY = new Order(
        "1",
        "1",
        15000L,
        LocalDate.now()
    );
}
