package app.foodylab.order;

import app.foodylab.user.User;

public class Order {
    private final User user;
    private final Store store;

    public Order(User user, Store store) {
        this.user = user;
        this.store = store;
    }

    public static Order of(User user, Store store) {
        isNullUser(user);
        isNullStore(store);
        return new Order(user, store);
    }

    private static void isNullStore(Store store) {
        if(store == null) throw new IllegalArgumentException("가게는 필수값 입니다.");
    }

    private static void isNullUser(User user) {
        if(user == null) throw new IllegalArgumentException("유저는 필수값 입니다.");
    }
}
