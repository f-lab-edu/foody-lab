package app.foodylab.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static app.foodylab.fixtures.OrderFixture.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrderTest {

    @Test
    @DisplayName("주문 하려고 하는 유저가 없으면 주문 생성이 안된다.")
    void test1() {
        assertThrows(IllegalArgumentException.class,
                () -> Order.of(
                        null,
                        STORE_ID,
                        ORDER_AMOUNT,
                        ORDERED_DATE()
                ), "유저는 필수값 입니다.");
    }

    @Test
    @DisplayName("주문 하려고 하는 가게가 없으면 주문 생성이 안된다.")
    void test2() {
        assertThrows(IllegalArgumentException.class,
                () -> Order.of(
                        USER_ID,
                        null,
                        ORDER_AMOUNT,
                        ORDERED_DATE()
                ), "가게는 필수값 입니다.");
    }

    @Test
    @DisplayName("주문 최소 수량 이상 이면 주문이 된다.")
    void test3() {
        assertDoesNotThrow(
                () -> Order.of(
                        USER_ID,
                        STORE_ID,
                        ORDER_AMOUNT,
                        ORDERED_DATE()
                ));
    }

//    @Test
//    @DisplayName("주문 최소 수량을 넘지 않으면 주문이 안된다.")
//    void test4() {
//        assertThrows(IllegalArgumentException.class,
//                () -> Order.of(
//
//                ), "주문 최소 금액 미만 입니다.");
//    }

    @Test
    @DisplayName("주문이 생성된 날짜가 이전이 아니면 주문이 된다.")
    void test5() {
        assertDoesNotThrow(
                () -> Order.of(
                        USER_ID,
                        STORE_ID,
                        ORDER_AMOUNT,
                        ORDERED_DATE()
                ));
    }

    @Test
    @DisplayName("주문이 생성된 날짜보다 이전이면 주문이 안된다.")
    void test6() {
        assertThrows(IllegalArgumentException.class,
                () -> Order.of(
                        USER_ID,
                        STORE_ID,
                        ORDER_AMOUNT,
                        ORDERED_MINUS_DATE(1L)
                ), "주문이 생성된 날짜보다 이전 입니다.");
    }
}
