package app.foodylab.domain.coupon;

import java.time.LocalDate;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Coupon {

    private final long discountAmount;
    private final String nameOfCoupon;
    private final CouponType typeOfCoupon;
    private final LocalDate startDate;
    private final LocalDate endDate;

    public static Coupon of(final Long discountAmount, String name, CouponType type) {
        require(discountAmount > 0, "할인 금액은 0보다 커야 합니다.");
        LocalDate now = LocalDate.now();
        return of(discountAmount, name, type, now, now.plusYears(1));
    }

    public static Coupon of(final long discountAmount, String name, CouponType type,
        final LocalDate startDate, final LocalDate endDate) {
        LocalDate now = LocalDate.now();
        require(discountAmount > 0, "할인 금액은 0보다 커야 합니다.");
        require(!startDate.isBefore(now), "쿠폰 사용 시작일은 현재보다 이전일 수 없습니다.");
        require(type != null, "쿠폰 종류는 필수값 입니다.");
        require(!endDate.isBefore(now), "쿠폰 사용 종료일은 현재보다 이전일 수 없습니다.");
        require(!endDate.isBefore(startDate), "쿠폰 사용 종료일은 시작일 이전일 수 없습니다.");
        return new Coupon(discountAmount, name, type, startDate, endDate);
    }

    private static void require(final boolean condition, final String msg) {
        if (!condition) {
            throw new IllegalArgumentException(msg);
        }
    }
}
