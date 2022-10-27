package app.foodylab.payment;

import app.foodylab.DiscountPriceCalculateService;
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
    final void init() {
        payMethodMap = payMethodList.stream().collect(Collectors.toMap(
            PayMethod::getMethod,
            payMethod -> payMethod,
            (oldPayMethod, newPayMethod) -> newPayMethod
        ));
    }

    public void pay(Order order, String payMethod, List<Coupon> coupons) {
        PayMethod method = payMethodMap.get(payMethod);
        DiscountPriceCalculateService discountPriceCalculateService = new DiscountPriceCalculateService();
        long price = discountPriceCalculateService.getPrice(order, coupons);
        method.pay(price);
    }
}
