package app.foodylab.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
public class Order {
    private final String userId;
    private final String storeId;
    private final long orderAmount;
    private final LocalDate orderedDate;

    public static Order of(String userId, String storeId, long orderAmount, LocalDate orderedDate) {
        isNullUser(userId);
        isNullStore(storeId);
//        isOrderAmountHigherThanMinimumOrderAmount(storeId, orderAmount);
        isBeforeDateOrdered(orderedDate);
        return new Order(userId, storeId, orderAmount, orderedDate);
    }

    private static void isBeforeDateOrdered(LocalDate orderedDate) {
        if (orderedDate.isBefore(LocalDate.now())) throw new IllegalArgumentException("주문이 생성된 날짜보다 이전 입니다.");
    }

//        추후 repository에서 storeId로 해당 가게 정보를 찾아 최소 주문 금액과 비교할 예정
//    private static void isOrderAmountHigherThanMinimumOrderAmount(String storeId, long orderAmount) {
//        if (store.getMinimumOrderAmount() > orderAmount) throw new IllegalArgumentException("주문 최소 금액 미만 입니다.");
//    }

    private static void isNullStore(String storeId) {
        if (storeId == null) throw new IllegalArgumentException("가게는 필수값 입니다.");
    }

    private static void isNullUser(String userId) {
        if (userId == null) throw new IllegalArgumentException("유저는 필수값 입니다.");
    }
}
