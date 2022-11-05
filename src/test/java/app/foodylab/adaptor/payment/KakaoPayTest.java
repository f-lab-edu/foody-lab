package app.foodylab.adaptor.payment;

import app.foodylab.domain.order.Order;
import app.foodylab.domain.payment.PayReadyRequest;
import java.time.LocalDate;
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
        PayReadyRequest payRequest = new PayReadyRequest(15000L, "appr", "cancel", "fail", "storId", "storeId", "orderId");
        boolean pay = kakaoPay.pay(payRequest);
        Assertions.assertTrue(pay);
    }

}
