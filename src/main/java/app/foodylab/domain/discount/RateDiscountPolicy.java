package app.foodylab.domain.discount;

public class RateDiscountPolicy implements DiscountPolicy {

    @Override
    public long discount(long productPrice, long discountRate) {
        return productPrice * discountRate / 100;
    }

}
