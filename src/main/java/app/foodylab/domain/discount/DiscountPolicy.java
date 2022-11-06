package app.foodylab.domain.discount;

public interface DiscountPolicy {

    long discount(long productPrice, long discountPrice);

}
