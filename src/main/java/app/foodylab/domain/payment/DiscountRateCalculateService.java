package app.foodylab.domain.payment;

import app.foodylab.application.coupon.Coupon;
import app.foodylab.domain.coupon.CouponType;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.lang.Nullable;

public class DiscountRateCalculateService {

    private static long getDiscountByRate(long price, List<Coupon> percentageCoupons) {
        List<Long> discountPrices = percentageCoupons.stream().map(Coupon::getDiscountPrice)
            .collect(Collectors.toList());
        return discountPrices.stream().mapToLong(i -> price * i / 100).sum();
    }

    public long getPrice(long orderedPrice, @Nullable List<Coupon> coupons) {

        List<Coupon> priceCoupons = coupons.stream().filter(s -> CouponType.RATE.equals(s.getCouponType()))
            .collect(Collectors.toList());
        long totalDiscount = getDiscountByRate(orderedPrice, priceCoupons);
        return totalDiscount;
    }
}