package app.foodylab;

import app.foodylab.domain.order.Order;
import java.time.LocalDate;

public class OrderFixture {

    private OrderFixture() {
    }

    public static final Order DUMMY = new Order(
        null,
        "1",
        "1",
        15000L,
        LocalDate.now()
    );
}
