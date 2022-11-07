package app.foodylab.domain.coupon;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

class CouponTest {

    @Test
    @DisplayName("할인 쿠폰의 할인 금액이 양수이면 정상적으로 생성해야 한다.")
    void test2() {
        Coupon coupon = Coupon.of(10000L, "할인쿠폰", CouponType.PRICE);
        Assertions.assertEquals("할인쿠폰", coupon.getName());
        Assertions.assertEquals(10000L, coupon.getDiscountAmount());
        Assertions.assertEquals(CouponType.PRICE, coupon.getType());
    }

    private static Collection<Arguments> param2() {
        LocalDate now = LocalDate.now();
        return Arrays.asList(
            Arguments.of("사용 시작일이 현재보다 이전일 경우 생성 불가해야 한다.", 10000L, "할인쿠폰", CouponType.PRICE,
                now.minusDays(1), now.plusYears(1), "쿠폰 사용 시작일은 현재보다 이전일 수 없습니다."),
            Arguments.of("사용 종료일이 현재보다 이전일 경우 생성 불가해야 한다.", 10000L, "할인쿠폰", CouponType.PRICE,
                now, now.minusDays(1), "쿠폰 사용 종료일은 현재보다 이전일 수 없습니다."),
            Arguments.of("사용 시작일 > 사용 종료일이면 생성 불가해야 한다.", 10000L, "할인쿠폰", CouponType.PRICE,
                now.plusDays(2), now.plusDays(1), "쿠폰 사용 종료일은 시작일 이전일 수 없습니다.")
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("param2")
    void test5(String description, long discountAmount, String name, CouponType type,
        LocalDate sdate, LocalDate edate, String error) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
            () -> Coupon.of(discountAmount, name, type, sdate, edate));
        Assertions.assertEquals(error, e.getMessage());
    }

    private static Collection<Arguments> argumentsStream1() {
        LocalDate now = LocalDate.now();
        return Arrays.asList(
            Arguments.of("쿠폰 종류가 없으면 에러가 발생한다.", 10000L, "할인쿠폰", null, "쿠폰 종류는 필수값 입니다."),
            Arguments.of("할인 쿠폰의 할인 금액이 음수이면 익셉션 발생해야 한다.", -10000L, "할인쿠폰", CouponType.PRICE,
                "할인 금액은 0보다 커야 합니다.")
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("argumentsStream1")
    void test4(String description, long discountAmount, String name, CouponType type,
        String error) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
            () -> Coupon.of(discountAmount, name, type));
        Assertions.assertEquals(error, e.getMessage());
    }
}
