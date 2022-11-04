package app.foodylab.application.coupon;

import app.foodylab.domain.coupon.CouponType;

public interface Coupon {

    long getDiscountPrice();

    CouponType getCouponType();
}
