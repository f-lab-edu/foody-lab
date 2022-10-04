package app.foodylab.order;

import app.foodylab.Store.Store;
import app.foodylab.user.User;

import java.time.LocalDate;

public class Order {
    private final User user;
    private final Store store;
    private final long orderAmount;
    private final LocalDate orderedDate;

    public Order(User user, Store store, long orderAmount, LocalDate orderedDate) {
        this.user = user;
        this.store = store;
        this.orderAmount = orderAmount;
        this.orderedDate = orderedDate;
    }

    public static Order of(User user, Store store, long orderAmount, LocalDate orderedDate) {
        isNullUser(user);
        isNullStore(store);
        isOrderAmountHigherThanMinimumOrderAmount(store, orderAmount);
        if(orderedDate.isBefore(LocalDate.now())) throw new IllegalArgumentException("주문이 생성된 날짜보다 이전 입니다.");
        return new Order(user, store, orderAmount, orderedDate);
    }

    private static void isOrderAmountHigherThanMinimumOrderAmount(Store store, long orderAmount) {
        if(store.getMinimumOrderAmount() > orderAmount) throw new IllegalArgumentException("주문 최소 금액 미만 입니다.");
    }

    private static void isNullStore(Store store) {
        if(store == null) throw new IllegalArgumentException("가게는 필수값 입니다.");
    }

    private static void isNullUser(User user) {
        if(user == null) throw new IllegalArgumentException("유저는 필수값 입니다.");
    }
}
