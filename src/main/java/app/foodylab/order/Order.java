package app.foodylab.order;

import app.foodylab.user.User;

public class Order {
    private final User user;

    public Order(User user) {
        this.user = user;
    }

    public static Order of(User user) {
        isNullUser(user);
        return new Order(user);
    }

    private static void isNullUser(User user) {
        if(user == null) throw new IllegalArgumentException("유저는 필수값 입니다.");
    }
}
