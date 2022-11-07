package app.foodylab.domain.order;

import java.time.LocalDateTime;
import java.util.function.Predicate;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Order {

    private final long id;
    private final String customerId;
    private final String storeId;
    private final long orderPrice;
    private final LocalDateTime orderedDateTime;

    public static Order of(long id, String customerId, String storeId, long orderAmount,
        LocalDateTime orderedDateTime) {
        require(ifNotStore -> storeId == null, storeId, "가게는 필수값 입니다.");
        require(ifNotCustomer -> customerId == null, customerId, "고객은 필수값 입니다.");
        return new Order(id, customerId, storeId, orderAmount, orderedDateTime);
    }

    private static <T> void require(Predicate<T> predicate, T target, String msg) {
        if (predicate.test(target)) {
            throw new IllegalArgumentException(msg);
        }
    }
}
