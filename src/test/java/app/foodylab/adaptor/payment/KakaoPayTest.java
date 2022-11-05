package app.foodylab.adaptor.payment;

import app.foodylab.OrderFixture;
import app.foodylab.domain.payment.PayReadyRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class KakaoPayTest {

    private final KakaoPay kakaoPay = new KakaoPay();

    @Test
    @DisplayName("카카오페이의 getMethod() 테스트")
    void test1() {
        Assertions.assertEquals("kakaoPay", kakaoPay.getMethod());
    }

    @Test
    @DisplayName("카카오페이의 pay() 테스트")
    void test2() {
        PayReadyRequest payRequest = PayReadyRequest.of(15000L, OrderFixture.DUMMY);
        boolean pay = kakaoPay.pay(payRequest);
        Assertions.assertTrue(pay);
    }

}
