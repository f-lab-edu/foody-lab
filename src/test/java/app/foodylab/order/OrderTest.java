package app.foodylab.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    @Test
    @DisplayName("주문한 유저가 없으면 주문 생성이 안된다.")
    void test1() {
        assertThrows(IllegalArgumentException.class, () -> Order.of(null));
    }
}
