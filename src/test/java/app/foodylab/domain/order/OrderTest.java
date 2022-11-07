package app.foodylab.domain.order;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class OrderTest {

    private static Collection<Arguments> argumentsStream1() {
        LocalDateTime now = LocalDateTime.now();
        Collection<Arguments> list = new ArrayList<>();
        list.add(
            Arguments.of("올바른 입력이면 주문이 생성된다.", "customerId", "storeId", 15000L, now)
        );
        return list;
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("argumentsStream1")
    void test1(String description, String customerId, String storeId, long orderPrice,
        LocalDateTime orderDate) {
        assertDoesNotThrow(() -> Order.of(1L, customerId, storeId, orderPrice, orderDate));
    }

    private static Collection<Arguments> argumentsStream2() {
        LocalDateTime now = LocalDateTime.now();
        return Arrays.asList(
            Arguments.of("Order 클래스의 of 메소드 테스트, 주문 하려고 하는 고객이 없으면 주문 생성이 안된다.", null, "storeId",
                10000L, now, "고객은 필수값 입니다."),
            Arguments.of("주문 하려고 하는 가게가 없으면 주문 생성이 안된다.", "customerId", null, 10000L, now,
                "가게는 필수값 입니다.")
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("argumentsStream2")
    void test2(String description, String customerId, String storeId, long orderPrice,
        LocalDateTime orderDate, String errorMsg) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
            () -> Order.of(1L, customerId, storeId, orderPrice, orderDate));
        assertThat(e.getMessage()).isEqualTo(errorMsg);
    }
}
