package app.foodylab;

import app.foodylab.domain.order.Order;
import java.time.LocalDateTime;

public class OrderFixture {

    public static Order ORDER = new Order(
        1L,
        "1",
        "1",
        15000L,
        LocalDateTime.now()
    );
}
