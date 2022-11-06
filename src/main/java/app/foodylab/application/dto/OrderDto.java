package app.foodylab.application.dto;

import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
public class OrderDto {
    private final long id;
    private final String customerId;
    private final String storeId;
    private final long orderPrice;
    private final LocalDate orderedDate;
}
