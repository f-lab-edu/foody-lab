package app.foodylab.adaptor;

import java.time.LocalDate;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class OrderDto {
    private final long id;
    private final String customerId;
    private final String storeId;
    private final long orderPrice;
    private final LocalDate orderedDate;
}
