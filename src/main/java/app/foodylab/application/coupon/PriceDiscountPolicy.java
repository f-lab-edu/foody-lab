package app.foodylab.application.coupon;

import app.foodylab.domain.coupon.CouponType;
import app.foodylab.domain.payment.DiscountPriceCalculateService;
import org.springframework.stereotype.Component;

@Component
public class PriceDiscountPolicy implements CouponDiscountPolicy {

    DiscountPriceCalculateService discountPriceCalculateService = new DiscountPriceCalculateService();

    @Override
    public long getCalculatedDiscountPrice(Coupon coupon, long productPrice) {

        return coupon.getDiscountPrice();
    }

    @Override
    public CouponType getCouponType() {
        return CouponType.PRICE;
    }
}
