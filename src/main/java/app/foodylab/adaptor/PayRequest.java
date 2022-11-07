package app.foodylab.adaptor;

import app.foodylab.application.dto.OrderDto;
import app.foodylab.domain.coupon.Coupon;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
public class PayRequest {
    private final OrderDto orderDto;
    private final String payMethod;
    private final Coupon coupons;
}
