package app.foodylab.payment;

import app.foodylab.adaptor.payment.KakaoPay;

public class KakaoPaySpy extends KakaoPay {

    private boolean isPaid = false;

    public boolean isPaid() {
        return isPaid;
    }

    @Override
    public boolean pay(long price) {
        isPaid = true;
        return true;
    }
}
