package app.foodylab.coupon.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
@Getter
public class PriceCoupon {

    private final int discountPrice;
    private final LocalDate startDate;
    private final LocalDate endDate;

    public static PriceCoupon of(int discountPrice) {
        require(discountPrice > 0, "할인 금액은 0보다 커야 합니다.");
        LocalDate now = LocalDate.now();
        return of(discountPrice, now, now.plusYears(1));
    }

    public static PriceCoupon of(int discountPrice, LocalDate startDate, LocalDate endDate) {
        LocalDate now = LocalDate.now();
        require(discountPrice > 0, "할인 금액은 0보다 커야 합니다.");
        require(!startDate.isBefore(now), "쿠폰 사용 시작일은 현재보다 이전일 수 없습니다.");
        require(!endDate.isBefore(now), "쿠폰 사용 종료일은 현재보다 이전일 수 없습니다.");
        require(!endDate.isBefore(startDate), "쿠폰 사용 종료일은 시작일 이전일 수 없습니다.");
        return new PriceCoupon(discountPrice, startDate, endDate);
    }

    private static void require(Boolean condition, String msg) {
        if (Boolean.FALSE.equals(condition)) throw new IllegalArgumentException(msg);
    }
}
