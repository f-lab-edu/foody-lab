package app.foodylab.domain.coupon;

import app.foodylab.application.coupon.Coupon;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RateCoupon implements Coupon {

    private final long discountRate;
    private final LocalDate startDate;
    private final LocalDate endDate;

    public static RateCoupon of(final long discountRate) {
        require(discountRate > 0, "할인 퍼센트는 0보다 커야 합니다.");
        LocalDate now = LocalDate.now();
        return of(discountRate, now, now.plusYears(1));
    }

    public static RateCoupon of(final long discountRate, final LocalDate startDate,
        final LocalDate endDate) {
        LocalDate now = LocalDate.now();
        require(discountRate > 0, "할인 퍼센트는 0보다 커야 합니다.");
        require(!startDate.isBefore(now), "쿠폰 사용 시작일은 현재보다 이전일 수 없습니다.");
        require(!endDate.isBefore(now), "쿠폰 사용 종료일은 현재보다 이전일 수 없습니다.");
        require(!endDate.isBefore(startDate), "쿠폰 사용 종료일은 시작일 이전일 수 없습니다.");
        return new RateCoupon(discountRate, startDate, endDate);
    }

    private static void require(final boolean condition, final String msg) {
        if (!condition) {
            throw new IllegalArgumentException(msg);
        }
    }

    @Override
    public long getDiscountPrice() {
        return discountRate;
    }

    @Override
    public CouponType getCouponType() {
        return CouponType.RATE;
    }
}
