package app.foodylab.domain.discount;

import app.foodylab.application.coupon.Coupon;
import app.foodylab.domain.coupon.CouponType;

public interface DiscountPolicy {

    long getCalculatedDiscountPrice(Coupon coupon, long productPrice);

    CouponType getCouponType();
}
