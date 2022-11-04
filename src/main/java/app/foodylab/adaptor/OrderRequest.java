package app.foodylab.adaptor;

import app.foodylab.application.coupon.Coupon;
import java.util.Collections;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.MODULE)
public class OrderRequest {
    @Getter
    private final OrderDto orderDto;
    @Getter
    private final String payMethod;
    private final List<Coupon> coupons;

    public List<Coupon> getCoupons() {
        return Collections.unmodifiableList(coupons);
    }
}
