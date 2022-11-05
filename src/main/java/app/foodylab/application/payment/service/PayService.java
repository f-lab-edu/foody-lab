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
        PayMethod method = payMethodMap.get(payMethod);
        long discountPrice = coupon.getDiscountPrice(order.getOrderPrice());
        PayReadyRequest payRequest = new PayReadyRequest(discountPrice, order.getStoreId(), order.getId());
        payRequest.setToken(order.getId());
        method.pay(payRequest);
    }
}
