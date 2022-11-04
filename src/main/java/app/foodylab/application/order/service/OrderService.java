package app.foodylab.application.order.service;

import static java.util.stream.Collectors.toMap;

import app.foodylab.application.coupon.Coupon;
import app.foodylab.application.coupon.CouponDiscountPolicy;
import app.foodylab.domain.coupon.CouponType;
import app.foodylab.domain.order.Order;
import java.time.LocalDate;
import java.util.EnumMap;
import java.util.List;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final Logger logger = LoggerFactory.getLogger(OrderService.class);

    private final List<CouponDiscountPolicy> couponDiscountPolicyList;
    private EnumMap<CouponType, CouponDiscountPolicy> couponServiceEnumMap;

    @PostConstruct
    final void init() {
        couponServiceEnumMap = couponDiscountPolicyList.stream()
            .collect(
                toMap(
                    CouponDiscountPolicy::getCouponType,
                    (createOrder) -> createOrder,
                    (oldService, newService) -> newService,
                    () -> new EnumMap<>(CouponType.class)
                )
            );
    }

    public Order order(String customerId, String storeId, long price,
        @Nullable List<Coupon> coupons) {
        long finalPrice = 0;
        for (Coupon coupon : coupons) {
            CouponDiscountPolicy couponDiscountPolicy = couponServiceEnumMap.get(
                coupon.getCouponType());
            finalPrice += couponDiscountPolicy.getCalculatedDiscountPrice(coupon, price);
        }
        long calculatedFinalPrice = price - finalPrice;
        if (calculatedFinalPrice < 0) {
            calculatedFinalPrice = 0;
        }

        logger.info("주문 완료, 가격: {}", calculatedFinalPrice);
        return Order.of(null, customerId, storeId, calculatedFinalPrice, LocalDate.now());
    }
}
