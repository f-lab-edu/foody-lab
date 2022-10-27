package app.foodylab.payment;

import app.foodylab.OrderFixture;
import java.util.Collections;
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
        payService.pay(OrderFixture.ORDER, "kakaoPay", Collections.EMPTY_LIST);
        Assertions.assertTrue(kakaoPay.isPaid());
    }
}