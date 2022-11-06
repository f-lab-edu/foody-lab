package app.foodylab.domain.coupon;

import app.foodylab.domain.discount.DiscountPolicy;
import app.foodylab.domain.discount.PriceDiscountPolicy;
import app.foodylab.domain.discount.RateDiscountPolicy;
import lombok.Getter;

public enum CouponType {
    PRICE(new PriceDiscountPolicy()),
    RATE(new RateDiscountPolicy());

    @Getter
    private final DiscountPolicy policy;

    CouponType(DiscountPolicy policy) {
        this.policy = policy;
    }
}
