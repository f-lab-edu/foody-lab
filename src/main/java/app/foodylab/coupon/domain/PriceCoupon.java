package app.foodylab.coupon.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

@RequiredArgsConstructor
@Getter
public class PriceCoupon {

    private final int discountPrice;
    private final LocalDate startDate;
    private final LocalDate endDate;

    public static PriceCoupon of(int discountPrice) {
        require(i -> i <= 0, discountPrice, "할인 금액은 0보다 커야 합니다.");
        LocalDate now = LocalDate.now();
        return of(discountPrice, now, now.plusYears(1));
    }

    public static PriceCoupon of(int discountPrice, LocalDate startDate, LocalDate endDate) {
        require(i -> i <= 0, discountPrice, "할인 금액은 0보다 커야 합니다.");
        require(sDate -> sDate.isBefore(LocalDate.now()), startDate, "쿠폰 사용 시작일은 현재보다 이전일 수 없습니다.");
        require(eDate -> eDate.isBefore(LocalDate.now()), endDate, "쿠폰 사용 종료일은 현재보다 이전일 수 없습니다.");
        require((sDate, eDate) -> eDate.isBefore(sDate), startDate, endDate, "쿠폰 사용 종료일은 시작일 이전일 수 없습니다.");
        return new PriceCoupon(discountPrice, startDate, endDate);
    }

    private static <T> void require(Predicate<T> predicate, T target, String msg) {
        if (predicate.test(target)) throw new IllegalArgumentException(msg);
    }

    private static <T, V> void require(BiPredicate<T, V> predicate, T target1, V target2, String msg) {
        if (predicate.test(target1, target2)) throw new IllegalArgumentException(msg);
    }
}
