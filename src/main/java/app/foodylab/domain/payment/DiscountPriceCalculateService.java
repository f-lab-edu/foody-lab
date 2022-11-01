package app.foodylab.domain.payment;

import app.foodylab.application.coupon.Coupon;
import app.foodylab.domain.order.Order;
import java.util.List;
import java.util.stream.Collectors;

public class DiscountPriceCalculateService {

    private static long getDiscountSum(List<Coupon> coupons) {
        List<Long> discountPrices = coupons.stream().map(Coupon::getDiscountPrice)
            .collect(Collectors.toList());
        return discountPrices.stream().mapToLong(i -> i).sum();
    }

    public long getPrice(Order order, List<Coupon> coupons) {
        long totalDiscount = getDiscountSum(coupons);
        return order.getOrderPrice() - totalDiscount;
    }

}
