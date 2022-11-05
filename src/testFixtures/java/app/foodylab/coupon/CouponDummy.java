package app.foodylab.coupon;

import app.foodylab.application.coupon.Coupon;

public class CouponDummy implements Coupon {

    public static final Coupon INSTANCE = new CouponDummy();
    @Override
    public long getDiscountPrice(long originPrice) {
        return 0;
    }
}
