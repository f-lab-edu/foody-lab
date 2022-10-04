package app.foodylab.order;

import app.foodylab.Store.Store;
import app.foodylab.Store.StoreState;
import app.foodylab.user.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    @Test
    @DisplayName("주문 하려고 하는 유저가 없으면 주문 생성이 안된다.")
    void test1() {
        assertThrows(IllegalArgumentException.class,
                () -> Order.of(
                        null,
                        new Store("1", "배배큐", StoreState.OPEN, 15000L),
                        20000L,
                        LocalDate.now()
                ));
    }

    @Test
    @DisplayName("주문 하려고 하는 가게가 없으면 주문 생성이 안된다.")
    void test2() {
        assertThrows(IllegalArgumentException.class,
                () -> Order.of(new User("1", "길동"), null, 15000L, LocalDate.now()));
    }

    @Test
    @DisplayName("주문 최소 수량 이상 이면 주문이 된다.")
    void test3() {
        assertDoesNotThrow(
                () -> Order.of(
                        new User("1", "길동"),
                        new Store("1", "배배큐", StoreState.OPEN, 15000L),
                        15000L,
                        LocalDate.now()
                ));
    }

    @Test
    @DisplayName("주문 최소 수량을 넘지 않으면 주문이 안된다.")
    void test4() {
        assertThrows(IllegalArgumentException.class,
                () -> Order.of(
                        new User("1", "길동"),
                        new Store("1", "배배큐", StoreState.OPEN, 15000L),
                        14000L,
                        LocalDate.now()
                ));
    }

    @Test
    @DisplayName("주문이 생성된 날짜가 이전이 아니면 주문이 된다.")
    void test5() {
        assertDoesNotThrow(
                () -> Order.of(
                        new User("1", "길동"),
                        new Store("1", "배배큐", StoreState.OPEN, 15000L),
                        16000L,
                        LocalDate.now()
                ));
    }

    @Test
    @DisplayName("주문이 생성된 날짜보다 이전이면 주문이 안된다.")
    void test6() {
        assertThrows(IllegalArgumentException.class,
                () -> Order.of(
                        new User("1", "길동"),
                        new Store("1", "배배큐", StoreState.OPEN, 15000L),
                        16000L,
                        LocalDate.now().minusDays(1)
                ));
    }
}
