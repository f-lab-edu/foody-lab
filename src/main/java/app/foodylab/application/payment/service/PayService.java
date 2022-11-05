package app.foodylab.application.payment.service;

import app.foodylab.application.coupon.Coupon;
import app.foodylab.application.payment.PayMethod;
import app.foodylab.domain.order.Order;
import app.foodylab.domain.payment.PayReadyRequest;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PayService {

    private final List<PayMethod> payMethodList;
    private Map<String, PayMethod> payMethodMap;

    @PostConstruct
    final void init() {
        payMethodMap = payMethodList.stream().collect(Collectors.toMap(
            PayMethod::getMethod,
            payMethod -> payMethod,
            (oldPayMethod, newPayMethod) -> newPayMethod
        ));
    }

    public void pay(Order order, String payMethod, Coupon coupon) {
        PayMethod method = getPayMethod(payMethod);
        long discountPrice = getDiscountPrice(order, coupon);
        PayReadyRequest payRequest = getPayReadyRequest(order, discountPrice);
        method.pay(payRequest);
    }

    private PayReadyRequest getPayReadyRequest(Order order, long discountPrice) {
        return PayReadyRequest.of(discountPrice, order);
    }

    private long getDiscountPrice(Order order, Coupon coupon) {
        return coupon.getDiscountPrice(order.getOrderPrice());
    }

    private PayMethod getPayMethod(String payMethod) {
        return payMethodMap.get(payMethod);
    }
}
