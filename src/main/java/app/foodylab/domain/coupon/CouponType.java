package app.foodylab.domain.coupon;

import app.foodylab.domain.discount.DiscountPolicy;
import app.foodylab.domain.discount.PriceDiscountPolicy;
import app.foodylab.domain.discount.RateDiscountPolicy;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CouponType {
    PRICE(new PriceDiscountPolicy()),
    RATE(new RateDiscountPolicy());

    private final DiscountPolicy policy;
}
