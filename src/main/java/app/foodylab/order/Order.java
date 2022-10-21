package app.foodylab.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.function.Predicate;

@Getter
@RequiredArgsConstructor
public class Order {
    private final String userId;
    private final String storeId;
    private final long orderAmount;
    private final LocalDate orderedDate;

    public static Order of(String userId, String storeId, long orderAmount, LocalDate orderedDate) {
        require(ifOrderBeforeDate -> orderedDate.isBefore(LocalDate.now()), orderedDate, "주문이 생성된 날짜보다 이전 입니다.");
        require(ifNotStore -> storeId == null, storeId, "가게는 필수값 입니다.");
        require(ifNotUser -> userId == null, userId, "유저는 필수값 입니다.");
        return new Order(userId, storeId, orderAmount, orderedDate);
    }

    private static <T> void require(Predicate<T> predicate, T target, String msg) {
        if (predicate.test(target)) throw new IllegalArgumentException(msg);
    }
}
