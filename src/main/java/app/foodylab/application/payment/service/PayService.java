package app.foodylab.application.payment.service;

import app.foodylab.application.coupon.Coupon;
import app.foodylab.application.payment.PayMethod;
import app.foodylab.domain.order.Order;
import app.foodylab.domain.payment.DiscountPriceCalculateService;
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
    private final DiscountPriceCalculateService discountPriceCalculateService = new DiscountPriceCalculateService();
    private Map<String, PayMethod> payMethodMap;

    @PostConstruct
    final void init() {
        payMethodMap = payMethodList.stream().collect(Collectors.toMap(
            PayMethod::getMethod,
            payMethod -> payMethod,
            (oldPayMethod, newPayMethod) -> newPayMethod
        ));
    }

    public void pay(Order order, String payMethod, List<Coupon> coupons) {
        PayMethod method = payMethodMap.get(payMethod);
        long price = discountPriceCalculateService.getPrice(order, coupons);
        method.pay(price);
    }
}
