package app.foodylab.application.payment.service;

import app.foodylab.application.dto.OrderDto;
import app.foodylab.application.order.mapper.OrderMapper;
import app.foodylab.application.payment.PayMethod;
import app.foodylab.domain.coupon.*;
import app.foodylab.domain.order.Order;
import java.util.*;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PayService {

    private final List<PayMethod> payMethodList;
    private Map<String, PayMethod> payMethodMap;
    private OrderMapper orderMapper = OrderMapper.INSTANCE;

    @PostConstruct
    final void init() {
        payMethodMap = payMethodList.stream().collect(Collectors.toMap(
            PayMethod::getMethod,
            payMethod -> payMethod,
            (oldPayMethod, newPayMethod) -> newPayMethod
        ));
    }

    public void pay(OrderDto orderDTO, String payMethod, Coupon coupon) {
        Order order = orderMapper.toOrder(orderDTO);
        PayMethod method = payMethodMap.get(payMethod);
        CouponType typeOfCoupon = coupon.getTypeOfCoupon();
        long price = typeOfCoupon.getPolicy()
            .discount(order.getOrderPrice(), coupon.getDiscountAmount());
        method.pay(price);
    }
}
