package app.foodylab.domain.payment;

import app.foodylab.application.coupon.Coupon;
import app.foodylab.domain.coupon.CouponType;
import java.util.List;
import java.util.stream.Collectors;

public class DiscountPriceCalculateService {

    private static long getDiscountSum(List<Coupon> coupons) {
        List<Long> discountPrices = coupons.stream().map(Coupon::getDiscountPrice)
            .collect(Collectors.toList());
        return discountPrices.stream().mapToLong(i -> i).sum();
    }

    public long getPrice(List<Coupon> coupons) {
        List<Coupon> priceCoupons = coupons.stream()
            .filter(s -> CouponType.PRICE.equals(s.getCouponType()))
            .collect(Collectors.toList());
        long totalDiscount = getDiscountSum(priceCoupons);
        return totalDiscount;
    }
}
