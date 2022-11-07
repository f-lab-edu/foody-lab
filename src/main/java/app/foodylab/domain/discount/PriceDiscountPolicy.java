package app.foodylab.domain.discount;

public class PriceDiscountPolicy implements DiscountPolicy {

    @Override
    public long discount(long productPrice, long discountPrice) {
        return productPrice - discountPrice;
    }

}
