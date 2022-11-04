package app.foodylab.adaptor.controller;

import app.foodylab.adaptor.OrderDto;
import app.foodylab.adaptor.OrderRequest;
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

    public void requestOrder(@RequestBody OrderRequest orderRequest) {
        payService.pay(orderRequest.getOrderDto(), orderRequest.getPayMethod(), orderRequest.getCoupons());
    }
}