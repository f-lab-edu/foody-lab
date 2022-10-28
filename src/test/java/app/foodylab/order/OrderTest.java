package app.foodylab.order;

import static app.foodylab.OrderFixture.ORDER;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import app.foodylab.domain.order.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderTest {

    @Test
    @DisplayName("주문 최소 수량 이상 이면 주문이 된다.")
    void test1() {
        assertDoesNotThrow(() ->
            Order.of(
                1,
                ORDER.getUserId(),
                ORDER.getStoreId(),
                ORDER.getOrderAmount(),
                ORDER.getOrderedDate()
            ));
    }

    @Test
    @DisplayName("주문이 생성된 날짜가 이전이 아니면 주문이 된다.")
    void test2() {
        assertDoesNotThrow(() ->
            Order.of(
                1,
                ORDER.getUserId(),
                ORDER.getStoreId(),
                ORDER.getOrderAmount(),
                ORDER.getOrderedDate()
            )
        );
    }

    @Test
    @DisplayName("주문 하려고 하는 유저가 없으면 주문 생성이 안된다.")
    void test3() {
        assertThrows(IllegalArgumentException.class,
            () -> Order.of(
                1,
                null,
                ORDER.getStoreId(),
                ORDER.getOrderAmount(),
                ORDER.getOrderedDate()
            ), "유저는 필수값 입니다.");
    }

    @Test
    @DisplayName("주문 하려고 하는 가게가 없으면 주문 생성이 안된다.")
    void test4() {
        assertThrows(IllegalArgumentException.class,
            () -> Order.of(
                1,
                ORDER.getUserId(),
                null,
                ORDER.getOrderAmount(),
                ORDER.getOrderedDate()
            ), "가게는 필수값 입니다.");
    }

    @Test
    @DisplayName("주문이 생성된 날짜보다 이전이면 주문이 안된다.")
    void test5() {
        assertThrows(IllegalArgumentException.class,
            () -> Order.of(
                1,
                ORDER.getUserId(),
                ORDER.getStoreId(),
                ORDER.getOrderAmount(),
                ORDER.getOrderedDate().minusDays(1)
            ), "주문이 생성된 날짜보다 이전 입니다.");
    }
}
