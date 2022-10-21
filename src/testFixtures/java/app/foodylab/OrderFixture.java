package app.foodylab;

import java.time.LocalDate;

public class OrderFixture {
    public static final String USER_ID = "1";
    public static final String STORE_ID = "1";
    public static final long ORDER_AMOUNT = 15000L;
    public static final LocalDate ORDERED_DATE = LocalDate.now();

    public static LocalDate orderedMinusDate(final Long minusDays) {
        return LocalDate.now().minusDays(minusDays);
    }
}
