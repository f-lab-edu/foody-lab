package app.foodylab.application.order.service;

import static org.assertj.core.api.Assertions.assertThat;

import app.foodylab.application.coupon.Coupon;
import app.foodylab.coupon.PriceDiscountPolicySpy;
import app.foodylab.coupon.RateDiscountPolicySpy;
import app.foodylab.domain.coupon.PriceCoupon;
import app.foodylab.domain.coupon.RateCoupon;
import app.foodylab.domain.order.Order;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderServiceTest {

    RateDiscountPolicySpy rateDiscountPolicy = new RateDiscountPolicySpy();
    PriceDiscountPolicySpy priceDiscountPolicy = new PriceDiscountPolicySpy();

    private OrderService sut = new OrderService(List.of(priceDiscountPolicy, rateDiscountPolicy));

    @BeforeAll
    void setUp() {
        sut.init();
    }

    @Test
    @DisplayName("고객은 고정할인 쿠폰 2장만 적용 후 주문한다.")
    void test1() {
        List<Coupon> couponList = new ArrayList<>();
        couponList.add(PriceCoupon.of(1000L));
        couponList.add(PriceCoupon.of(1000L));

        Order actual = sut.order("1", "2", 15000L, couponList);

        assertThat(actual).isNotNull();
        assertThat(actual.getCustomerId()).isEqualTo("1");
        assertThat(actual.getStoreId()).isEqualTo("2");
        assertThat(actual.getOrderPrice()).isEqualTo(13000L);
    }

    @Test
    @DisplayName("고객은 퍼센트할인 쿠폰 2장만 적용 후 주문한다.")
    void test2() {
        List<Coupon> couponList = new ArrayList<>();
        couponList.add(RateCoupon.of(10L));
        couponList.add(RateCoupon.of(30L));

        Order actual = sut.order("1", "2", 15000L, couponList);

        assertThat(actual).isNotNull();
        assertThat(actual.getCustomerId()).isEqualTo("1");
        assertThat(actual.getStoreId()).isEqualTo("2");
        assertThat(actual.getOrderPrice()).isEqualTo(9000L);
    }

    @Test
    @DisplayName("고객은 고정할인 쿠폰 2장 + 퍼센트할인 2장 섞어서 계산 후 주문한다.")
    void test3() {
        List<Coupon> couponList = new ArrayList<>();
        couponList.add(PriceCoupon.of(1000L));
        couponList.add(PriceCoupon.of(1000L));
        couponList.add(RateCoupon.of(10L));
        couponList.add(RateCoupon.of(5L));

        Order actual = sut.order("1", "2", 15000L, couponList);

        assertThat(actual).isNotNull();
        assertThat(actual.getCustomerId()).isEqualTo("1");
        assertThat(actual.getStoreId()).isEqualTo("2");
        assertThat(actual.getOrderPrice()).isEqualTo(10750L);
    }
}
