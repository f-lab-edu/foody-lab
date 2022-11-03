package app.foodylab.domain.order;

import static app.foodylab.OrderFixture.ORDER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class OrderTest {

    private static Collection<Arguments> argumentsStream1() {
        LocalDate now = LocalDate.now();
        Collection<Arguments> list = new ArrayList<>();
        list.add(
            Arguments.of("Order 클래스의 of 메소드 테스트, 주문 하려고 하는 고객이 없으면 주문 생성이 안된다.", 1L, null,
                "storeId",
                10000L, now,
                "고객은 필수값 입니다.")
        );
        list.add(
            Arguments.of("주문 하려고 하는 가게가 없으면 주문 생성이 안된다.", 1L, "customerId", null, 10000L, now,
                "가게는 필수값 입니다.")
        );

        return list;
    }

    @Test
    @DisplayName("주문 최소 수량 이상 이면 주문이 된다.")
    void test1() {
        assertDoesNotThrow(() ->
            Order.of(
                ORDER.getId(),
                ORDER.getCustomerId(),
                ORDER.getStoreId(),
                ORDER.getOrderPrice(),
                ORDER.getOrderedDate()
            ));
    }

    @Test
    @DisplayName("주문이 생성된 날짜가 이전이 아니면 주문이 된다.")
    void test2() {
        assertDoesNotThrow(() ->
            Order.of(
                ORDER.getId(),
                ORDER.getCustomerId(),
                ORDER.getStoreId(),
                ORDER.getOrderPrice(),
                ORDER.getOrderedDate()
            )
        );
    }

    @Test
    @DisplayName("Order 클래스의 of 메소드 테스트, 주문 하려고 하는 고객이 없으면 주문 생성이 안된다.")
    void test3() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
            () -> Order.of(1L, null, "store_id", 1000L, LocalDate.now()));
        assertThat(e.getMessage()).isEqualTo("고객은 필수값 입니다.");
    }

    @Test
    @DisplayName("주문 하려고 하는 가게가 없으면 주문 생성이 안된다.")
    void test4() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
            () -> Order.of(1L, "customer_id", null, 10000L, LocalDate.now()));
        assertThat(e.getMessage()).isEqualTo("가게는 필수값 입니다.");
    }

    @Test
    @DisplayName("주문이 생성된 날짜보다 이전이면 주문이 안된다.")
    void test5() {
        IllegalArgumentException e = assertThrows(
            IllegalArgumentException.class,
            () -> Order.of(
                1L,
                "customer_id",
                "store_id",
                10000L,
                LocalDate.now().minusDays(1)
            ));
        assertThat(e.getMessage()).isEqualTo("주문이 생성된 날짜보다 이전 입니다.");
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("argumentsStream1")
    void test6(String description, long id, String customerId, String storeId, long orderPrice,
        LocalDate orderDate, String errorMsg) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
            () -> Order.of(id, customerId, storeId, orderPrice, orderDate));
        assertThat(e.getMessage()).isEqualTo(errorMsg);
    }
}
