package app.foodylab.adaptor.controller;

import app.foodylab.adaptor.OrderDto;
import app.foodylab.application.coupon.Coupon;
import app.foodylab.application.payment.service.PayService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Ordercontroller {

    private final PayService payService;

    public void requestOrder(@RequestBody OrderDto orderDto, String payMethod, List<Coupon> coupons) {
        payService.pay(orderDto, payMethod, coupons);
    }
}
