package app.foodylab;

import app.foodylab.coupon.application.Coupon;
import app.foodylab.order.Order;
import java.util.List;
import java.util.stream.Collectors;

public class DiscountPriceCalculateService {

    public long getPrice(Order order, List<Coupon> coupons) {
        long totalDiscount = getDiscountSum(coupons);
        return order.getOrderPrice() - totalDiscount;
    }

    private static long getDiscountSum(List<Coupon> coupons) {
        List<Long> discountPrices = coupons.stream().map(Coupon::getDiscountPrice)
            .collect(Collectors.toList());
        return discountPrices.stream().mapToLong(i -> i).sum();
    }

}
