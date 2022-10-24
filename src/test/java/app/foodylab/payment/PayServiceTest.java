package app.foodylab.payment;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import app.foodylab.OrderFixture;
import java.util.Collections;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PayServiceTest {
    private final PayService payService = mock(PayService.class);

    @Test
    @DisplayName("페이 서비스를 호출하면 pay 메소드가 호출되는지 테스트")
    void test1() {
        payService.pay(OrderFixture.ORDER, "kakaoPay", Collections.EMPTY_LIST);
        verify(payService, times(1)).pay(any(), anyString(), anyList());
    }
}
