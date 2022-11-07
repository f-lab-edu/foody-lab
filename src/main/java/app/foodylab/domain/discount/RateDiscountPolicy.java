package app.foodylab.domain.discount;

public class RateDiscountPolicy implements DiscountPolicy {

    @Override
    public long discount(long productPrice, long discountAmount) {
        return productPrice * discountAmount / 100;
    }

}
