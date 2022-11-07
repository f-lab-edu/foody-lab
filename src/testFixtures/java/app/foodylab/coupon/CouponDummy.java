package app.foodylab.coupon;

import app.foodylab.domain.coupon.Coupon;
import app.foodylab.domain.coupon.CouponType;
import java.time.LocalDate;

public class CouponDummy extends Coupon {

    public static final Coupon INSTANCE = Coupon.of(1000L, "coupon", CouponType.PRICE);

    public CouponDummy(long discountAmount, String nameOfCoupon, CouponType typeOfCoupon,
        LocalDate startDate, LocalDate endDate) {
        super(discountAmount, nameOfCoupon, typeOfCoupon, startDate, endDate);
    }
}
