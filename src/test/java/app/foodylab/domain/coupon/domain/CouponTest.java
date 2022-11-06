package app.foodylab.domain.coupon.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import app.foodylab.domain.coupon.Coupon;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CouponTest {

    @Test
    @DisplayName("할인 쿠폰의 할인 금액이 음수이면 익셉션 발생해야 한다.")
    void test1() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
            () -> Coupon.of(-10000L, "할인쿠폰", "가격할인쿠폰"));
        assertThat(e.getMessage()).isEqualTo("할인 금액은 0보다 커야 합니다.");
    }

    @Test
    @DisplayName("할인 쿠폰의 할인 금액이 양수이면 정상적으로 생성해야 한다.")
    void test2() {
        assertDoesNotThrow(() -> Coupon.of(10000L, "할인쿠폰", "가격할인쿠폰"));
    }

    @Test
    @DisplayName("사용 시작일이 현재보다 이전일 경우 생성 불가해야 한다.")
    void test3() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
            () -> Coupon.of(10000L, "할인쿠폰", "가격할인쿠폰", LocalDate.now().minusDays(1),
                LocalDate.now().plusYears(1)));
        assertThat(e.getMessage()).isEqualTo("쿠폰 사용 시작일은 현재보다 이전일 수 없습니다.");

    }

    @Test
    @DisplayName("사용 종료일이 현재보다 이전일 경우 생성 불가해야 한다.")
    void test4() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
            () -> Coupon.of(10000L, "할인쿠폰", "가격할인쿠폰", LocalDate.now(),
                LocalDate.now().minusDays(1)));
        assertThat(e.getMessage()).isEqualTo("쿠폰 사용 종료일은 현재보다 이전일 수 없습니다.");
    }

    @Test
    @DisplayName(" [사용 시작일 > 사용 종료일]이면 생성 불가해야 한다.")
    void test5() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
            () -> Coupon.of(10000L, "할인쿠폰", "가격할인쿠폰", LocalDate.now().plusDays(2),
                LocalDate.now().plusDays(1)));
        assertThat(e.getMessage()).isEqualTo("쿠폰 사용 종료일은 시작일 이전일 수 없습니다.");
    }
}
