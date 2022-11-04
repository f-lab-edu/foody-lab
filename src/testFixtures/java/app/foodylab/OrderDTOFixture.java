package app.foodylab;

import app.foodylab.adaptor.OrderDTO;
import java.time.LocalDate;

public class OrderDTOFixture {
    public static OrderDTO ORDERDTO = new OrderDTO(10L, "1", "1", 15000L, LocalDate.now());
}
