package app.foodylab.coupon.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class PriceCouponTest {

    @Test
    @DisplayName("할인 쿠폰의 할인 금액이 음수이면 익셉션 발생")
    void test1() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> PriceCoupon.of(-10000), "할인 금액은 0보다 커야 합니다.");
    }

    @Test
    @DisplayName("할인 쿠폰의 할인 금액이 양수이면 정상적으로 생성")
    void test2() {
        Assertions.assertDoesNotThrow(() -> PriceCoupon.of(10000));
    }

    @Test
    @DisplayName("사용 시작일이 현재보다 이전일 경우 생성 불가")
    void test3() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> PriceCoupon.of(10000, LocalDate.now().minusDays(1), LocalDate.now().plusYears(1)), "쿠폰 사용 시작일은 현재보다 이전일 수 없습니다.");
    }

    @Test
    @DisplayName("사용 종료일이 현재보다 이전일 경우 생성 불가")
    void test4() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> PriceCoupon.of(10000, LocalDate.now(), LocalDate.now().minusDays(1)), "쿠폰 사용 종료일은 현재보다 이전일 수 없습니다.");
    }

    @Test
    @DisplayName(" [사용 시작일 > 사용 종료일]이면 생성 불가")
    void test5() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> PriceCoupon.of(10000, LocalDate.now().plusDays(2), LocalDate.now().plusDays(1)), "쿠폰 사용 종료일은 시작일 이전일 수 없습니다.");
    }
}
