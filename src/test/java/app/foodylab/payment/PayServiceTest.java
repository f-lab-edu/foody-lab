package app.foodylab.payment;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import app.foodylab.OrderFixture;
import app.foodylab.payment.adapter.KakaoPay;
import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PayServiceTest {
    KakaoPay kakaoPay = mock(KakaoPay.class);
    private final PayService payService = new PayService(Arrays.asList(kakaoPay));

    @BeforeAll
    static void init() {

    }

    @Test
    @DisplayName("페이 서비스를 호출하면 pay 메소드가 호출되는지 테스트")
    void test1() {
        payService.pay(OrderFixture.ORDER, "kakaoPay", Collections.EMPTY_LIST);
        verify(kakaoPay, times(1)).pay(OrderFixture.ORDER.getOrderPrice());
    }
}
