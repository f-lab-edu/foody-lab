package app.foodylab.domain.discount;

import app.foodylab.application.coupon.Coupon;
import app.foodylab.domain.coupon.CouponType;
import app.foodylab.domain.payment.DiscountPriceCalculateService;
import org.springframework.stereotype.Component;

@Component
public class RateDiscountPolicy implements DiscountPolicy {

    private DiscountPriceCalculateService discountPriceCalculateService = new DiscountPriceCalculateService();

    @Override
    public long getCalculatedDiscountPrice(Coupon coupon, long productPrice) {

        long calculatedFinalPrice = coupon.getDiscountPrice() * productPrice / 100;

        return calculatedFinalPrice;
    }

    @Override
    public CouponType getCouponType() {
        return CouponType.RATE;
    }
}
