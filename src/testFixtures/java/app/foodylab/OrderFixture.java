package app.foodylab;

import app.foodylab.order.Order;

import java.time.LocalDate;

public class OrderFixture {
    public static final LocalDate ORDERED_DATE = LocalDate.now();

    public static Order createFineOrder() {
        return Order.of(
                "1",
                "1",
                15000L,
                ORDERED_DATE
        );
    }

    public static Order createOrderWithOutUserId() {
        return Order.of(
                null,
                "1",
                15000L,
                ORDERED_DATE
        );
    }

    public static Order createOrderWithOutStoreId() {
        return Order.of(
                "1",
                null,
                15000L,
                ORDERED_DATE
        );
    }

    public static Order createOrderBeforeTheDate() {
        return Order.of(
                "1",
                "1",
                15000L,
                orderedMinusDate(1L)
        );
    }

    public static LocalDate orderedMinusDate(final Long minusDays) {
        return LocalDate.now().minusDays(minusDays);
    }
}
