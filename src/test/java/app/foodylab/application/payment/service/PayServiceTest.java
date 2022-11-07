package app.foodylab.application.payment.service;

import app.foodylab.OrderFixture;
import app.foodylab.domain.coupon.Coupon;
import app.foodylab.domain.coupon.CouponType;
import app.foodylab.payment.KakaoPaySpy;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PayServiceTest {

    private static final KakaoPaySpy kakaoPay = new KakaoPaySpy();
    private static final PayService payService = new PayService(List.of(kakaoPay));

    @BeforeAll
    static void init() {
        payService.init();
    }

    @Test
    @DisplayName("페이 서비스를 호출하면 pay 메소드가 호출되는지 테스트")
    void test1() {
        payService.pay(OrderFixture.ORDER, "kakaoPay", Coupon.of(1L, "할인쿠폰", CouponType.PRICE));
        Assertions.assertTrue(kakaoPay.isPaid());
    }
}
