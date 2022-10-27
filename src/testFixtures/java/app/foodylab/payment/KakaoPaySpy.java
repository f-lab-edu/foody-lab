package app.foodylab.payment;

import app.foodylab.payment.adapter.KakaoPay;

public class KakaoPaySpy extends KakaoPay{

    private boolean isPaid = false;

    public boolean isPaid() {
        return isPaid;
    }

    @Override
    public void pay(long price) {
        isPaid = true;
    }
}
