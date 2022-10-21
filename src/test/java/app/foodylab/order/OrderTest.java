package app.foodylab.order;

import app.foodylab.OrderFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrderTest {

    @Test
    @DisplayName("주문 최소 수량 이상 이면 주문이 된다.")
    void test1() {
        assertDoesNotThrow(() ->
                Order.of(
                        OrderFixture.USER_ID,
                        OrderFixture.STORE_ID,
                        OrderFixture.ORDER_AMOUNT,
                        OrderFixture.ORDERED_DATE
                )
        );
    }

    @Test
    @DisplayName("주문이 생성된 날짜가 이전이 아니면 주문이 된다.")
    void test2() {
        assertDoesNotThrow(() ->
                Order.of(
                        OrderFixture.USER_ID,
                        OrderFixture.STORE_ID,
                        OrderFixture.ORDER_AMOUNT,
                        OrderFixture.ORDERED_DATE
                )
        );
    }

    @Test
    @DisplayName("주문 하려고 하는 유저가 없으면 주문 생성이 안된다.")
    void test3() {
        assertThrows(IllegalArgumentException.class,
                () -> Order.of(
                        null,
                        OrderFixture.STORE_ID,
                        OrderFixture.ORDER_AMOUNT,
                        OrderFixture.ORDERED_DATE
                ), "유저는 필수값 입니다.");
    }

    @Test
    @DisplayName("주문 하려고 하는 가게가 없으면 주문 생성이 안된다.")
    void test4() {
        assertThrows(IllegalArgumentException.class,
                () -> Order.of(
                        OrderFixture.USER_ID,
                        null,
                        OrderFixture.ORDER_AMOUNT,
                        OrderFixture.ORDERED_DATE
                ), "가게는 필수값 입니다.");
    }

    @Test
    @DisplayName("주문이 생성된 날짜보다 이전이면 주문이 안된다.")
    void test5() {
        assertThrows(IllegalArgumentException.class,
                () -> Order.of(
                        OrderFixture.USER_ID,
                        OrderFixture.STORE_ID,
                        OrderFixture.ORDER_AMOUNT,
                        OrderFixture.orderedMinusDate(1L)
                ), "주문이 생성된 날짜보다 이전 입니다.");
    }
}
