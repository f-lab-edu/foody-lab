package app.foodylab;

import app.foodylab.adaptor.OrderDto;
import java.time.LocalDate;

public class OrderDTOFixture {
    public static OrderDto ORDERDTO = new OrderDto(10L, "1", "1", 15000L, LocalDate.now());
}
