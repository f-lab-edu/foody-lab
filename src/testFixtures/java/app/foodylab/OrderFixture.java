package app.foodylab;

import app.foodylab.order.Order;

import java.time.LocalDate;

public class OrderFixture {
    public static Order ORDER = new Order(
            "1",
            "1",
            15000L,
            LocalDate.now()
    );
}
