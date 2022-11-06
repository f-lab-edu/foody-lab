package app.foodylab.application.order.service;

import static org.assertj.core.api.Assertions.assertThat;

import app.foodylab.coupon.PriceDiscountPolicySpy;
import app.foodylab.coupon.RateDiscountPolicySpy;
import app.foodylab.domain.coupon.Coupon;
import app.foodylab.domain.order.Order;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
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
        List<app.foodylab.application.coupon.Coupon> couponList = new ArrayList<>();
        couponList.add(Coupon.of(1000L));
        couponList.add(Coupon.of(1000L));

        Order actual = sut.order("1", "2", 15000L, couponList);

        assertThat(actual).isNotNull();
        assertThat(actual.getCustomerId()).isEqualTo("1");
        assertThat(actual.getStoreId()).isEqualTo("2");
        assertThat(actual.getOrderPrice()).isEqualTo(13000L);
    }

    @Test
    @DisplayName("고객은 퍼센트할인 쿠폰 2장만 적용 후 주문한다.")
    void test2() {
        List<app.foodylab.application.coupon.Coupon> couponList = new ArrayList<>();
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
        List<app.foodylab.application.coupon.Coupon> couponList = new ArrayList<>();
        couponList.add(Coupon.of(1000L));
        couponList.add(Coupon.of(1000L));
        couponList.add(RateCoupon.of(10L));
        couponList.add(RateCoupon.of(5L));

        Order actual = sut.order("1", "2", 15000L, couponList);

        assertThat(actual).isNotNull();
        assertThat(actual.getCustomerId()).isEqualTo("1");
        assertThat(actual.getStoreId()).isEqualTo("2");
        assertThat(actual.getOrderPrice()).isEqualTo(10750L);
    }

    @Test
    @DisplayName("할인 쿠폰을 적용 후 음수가 되면 최종 주문 가격은 0이 된다.")
    void test4() {
        List<app.foodylab.application.coupon.Coupon> couponList = new ArrayList<>();
        couponList.add(Coupon.of(1000L));
        couponList.add(Coupon.of(1000L));
        couponList.add(RateCoupon.of(10L));
        couponList.add(RateCoupon.of(90L));

        Order actual = sut.order("1", "2", 15000L, couponList);

        assertThat(actual).isNotNull();
        assertThat(actual.getCustomerId()).isEqualTo("1");
        assertThat(actual.getStoreId()).isEqualTo("2");
        assertThat(actual.getOrderPrice()).isEqualTo(0);
    }
}
