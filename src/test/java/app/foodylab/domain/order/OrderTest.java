package app.foodylab.domain.order;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class OrderTest {

    private static Collection<Arguments> argumentsStream1() {
        LocalDate now = LocalDate.now();
        Collection<Arguments> list = new ArrayList<>();
        list.add(
            Arguments.of("올바른 입력이면 주문이 생성된다.", "customerId", "storeId", 15000L, now)
        );
        return list;
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("argumentsStream1")
    void test4(String description, String customerId, String storeId, long orderPrice,
        LocalDate orderDate) {
        assertDoesNotThrow(() -> Order.of(customerId, storeId, orderPrice, orderDate));
    }

    private static Collection<Arguments> argumentsStream2() {
        LocalDate now = LocalDate.now();
        Collection<Arguments> list = new ArrayList<>();
        list.add(
            Arguments.of("Order 클래스의 of 메소드 테스트, 주문 하려고 하는 고객이 없으면 주문 생성이 안된다.", null, "storeId",
                10000L, now, "고객은 필수값 입니다.")
        );
        list.add(
            Arguments.of("주문 하려고 하는 가게가 없으면 주문 생성이 안된다.", "customerId", null, 10000L, now,
                "가게는 필수값 입니다.")
        );
        list.add(
            Arguments.of("주문이 생성된 날짜보다 이전이면 주문이 안된다.", "customerId", "storeId", 10000L,
                now.minusDays(1), "주문이 생성된 날짜보다 이전 입니다.")
        );
        return list;
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("argumentsStream2")
    void test3(String description, String customerId, String storeId, long orderPrice,
        LocalDate orderDate, String errorMsg) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
            () -> Order.of(customerId, storeId, orderPrice, orderDate));
        assertThat(e.getMessage()).isEqualTo(errorMsg);
    }
}
