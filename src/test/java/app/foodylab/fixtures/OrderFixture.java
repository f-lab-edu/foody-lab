package app.foodylab.fixtures;

import java.time.LocalDate;

public class OrderFixture {
    public static final String USER_ID = "1";
    public static final String STORE_ID = "1";
    public static final long ORDER_AMOUNT = 15000L;

    public static LocalDate ORDERED_DATE() {
        return LocalDate.now();
    }

    public static LocalDate ORDERED_PLUS_DATE(final Long plusDays) {
        return LocalDate.now().plusDays(plusDays);
    }

    public static LocalDate ORDERED_MINUS_DATE(final Long minusDays) {
        return LocalDate.now().minusDays(minusDays);
    }
}
