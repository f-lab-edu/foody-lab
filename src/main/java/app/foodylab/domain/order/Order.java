package app.foodylab.domain.order;

import java.time.LocalDate;
import java.util.function.Predicate;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Order {

    private String id;
    private final String customerId;
    private final String storeId;
    private final long orderPrice;
    private final LocalDate orderedDate;

    public static Order of(String customerId, String storeId, long orderAmount,
        LocalDate orderedDate) {
        return of(null, customerId, storeId, orderAmount, orderedDate);
    }

    public static Order of(String id, String customerId, String storeId, long orderAmount,
        LocalDate orderedDate) {
        require(ifOrderBeforeDate -> orderedDate.isBefore(LocalDate.now()), orderedDate,
            "주문이 생성된 날짜보다 이전 입니다.");
        require(ifNotStore -> storeId == null, storeId, "가게는 필수값 입니다.");
        require(ifNotCustomer -> customerId == null, customerId, "고객은 필수값 입니다.");
        return new Order(customerId, storeId, orderAmount, orderedDate);
    }

    private static <T> void require(Predicate<T> predicate, T target, String msg) {
        if (predicate.test(target)) {
            throw new IllegalArgumentException(msg);
        }
    }
}
