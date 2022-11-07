package app.foodylab.payment;

import app.foodylab.adaptor.payment.KakaoPay;
import app.foodylab.domain.payment.PayApproveResponse;
import app.foodylab.domain.payment.PayReadyRequest;

public class KakaoPaySpy extends KakaoPay {

    private boolean isPaid = false;

    public boolean isPaid() {
        return isPaid;
    }

    @Override
    public PayApproveResponse pay(PayReadyRequest readyRequest) {
        isPaid = true;
        return super.pay(readyRequest);
    }
}
