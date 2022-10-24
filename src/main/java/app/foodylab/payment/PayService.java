package app.foodylab.payment;

import app.foodylab.coupon.application.Coupon;
import app.foodylab.order.Order;
import app.foodylab.payment.application.PayMethod;
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
    private void init() {
        payMethodMap = payMethodList.stream().collect(Collectors.toMap(
            PayMethod::getMethod,
            payMethod -> payMethod,
            (oldPayMethod, newPayMethod) -> newPayMethod
        ));
    }

    public void pay(Order order, String payMethod, List<Coupon> coupons) {
        PayMethod method = payMethodMap.get(payMethod);
        long orderAmount = order.getOrderAmount();
        for (Coupon coupon:coupons) {
            Long discountPrice = coupon.getDiscountPrice();
            orderAmount -= discountPrice;
        }
        method.pay(orderAmount);
    }
}
