package app.foodylab.application.coupon;

import app.foodylab.domain.coupon.CouponType;

public interface CouponDiscountPolicy {

    long getCalculatedDiscountPrice(Coupon coupon, long productPrice);

    CouponType getCouponType();
}
