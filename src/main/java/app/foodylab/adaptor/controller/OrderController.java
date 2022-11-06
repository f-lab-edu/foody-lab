package app.foodylab.adaptor.controller;

import app.foodylab.adaptor.OrderRequest;
import app.foodylab.application.payment.service.PayService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final PayService payService;

    @PostMapping("/pay")
    public void requestOrder(@RequestBody OrderRequest orderRequest) {
        payService.pay(orderRequest.getOrderDto(), orderRequest.getPayMethod(), orderRequest.getCoupons());
    }
}
