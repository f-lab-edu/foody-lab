package app.foodylab.order;

import app.foodylab.user.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    @Test
    @DisplayName("주문한 유저가 없으면 주문 생성이 안된다.")
    void test1() {
        assertThrows(IllegalArgumentException.class, () -> Order.of(null, new Store("1", "배배큐")));
    }

    @Test
    @DisplayName("주문한 가게가 없으면 주문 생성이 안된다.")
    void test2() {
        assertThrows(IllegalArgumentException.class, () -> Order.of(new User("1", "길동"), null));
    }
}
