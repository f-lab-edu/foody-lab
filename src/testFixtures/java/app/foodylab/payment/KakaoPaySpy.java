package app.foodylab.payment;

import app.foodylab.adaptor.payment.KakaoPay;
import app.foodylab.domain.order.Order;

public class KakaoPaySpy extends KakaoPay {

    private boolean isPaid = false;

    public boolean isPaid() {
        return isPaid;
    }

    @Override
    public boolean pay(Order order) {
        isPaid = true;
        return true;
    }
}
