package app.foodylab.domain.payment;

import app.foodylab.application.coupon.Coupon;
import app.foodylab.domain.order.Order;
import java.util.List;
import java.util.stream.Collectors;

public class DiscountPriceCalculateService {

    private long getDiscountSum(List<Coupon> coupons) {
        List<Long> discountPrices = coupons.stream().map(Coupon::getDiscountPrice)
            .collect(Collectors.toList());
        return discountPrices.stream().mapToLong(i -> i).sum();
    }

    public Order getOrder(Order order, List<Coupon> coupons) {
        long totalDiscount = getDiscountSum(coupons);
        long price = order.getOrderPrice() - totalDiscount;
        return Order.of(order.getCustomerId(), order.getStoreId(), price, order.getOrderedDate());
    }

}
