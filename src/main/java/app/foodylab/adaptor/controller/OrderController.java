package app.foodylab.adaptor.controller;

import app.foodylab.adaptor.PayRequest;
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
    public void requestPay(@RequestBody PayRequest payRequest) {
        payService.pay(payRequest.getOrderDto(), payRequest.getPayMethod(), payRequest.getCoupons());
    }
}
