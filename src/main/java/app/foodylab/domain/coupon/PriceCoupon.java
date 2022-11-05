package app.foodylab.domain.coupon;

import app.foodylab.application.coupon.Coupon;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PriceCoupon implements Coupon {

    private final long discountPrice;
    private final LocalDate startDate;
    private final LocalDate endDate;

    public static PriceCoupon of(final Long discountPrice) {
        require(discountPrice > 0, "할인 금액은 0보다 커야 합니다.");
        LocalDate now = LocalDate.now();
        return of(discountPrice, now, now.plusYears(1));
    }

    public static PriceCoupon of(final long discountPrice, final LocalDate startDate,
        final LocalDate endDate) {
        LocalDate now = LocalDate.now();
        require(discountPrice > 0, "할인 금액은 0보다 커야 합니다.");
        require(!startDate.isBefore(now), "쿠폰 사용 시작일은 현재보다 이전일 수 없습니다.");
        require(!endDate.isBefore(now), "쿠폰 사용 종료일은 현재보다 이전일 수 없습니다.");
        require(!endDate.isBefore(startDate), "쿠폰 사용 종료일은 시작일 이전일 수 없습니다.");
        return new PriceCoupon(discountPrice, startDate, endDate);
    }

    private static void require(final boolean condition, final String msg) {
        if (!condition) {
            throw new IllegalArgumentException(msg);
        }
    }

    @Override
    public long getDiscountPrice(long originPrice) {
        return originPrice - discountPrice;
    }
}
