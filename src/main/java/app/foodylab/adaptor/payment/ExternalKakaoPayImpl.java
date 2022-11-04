package app.foodylab.adaptor.payment;

import app.foodylab.application.payment.ExternalPayAPI;

public class ExternalKakaoPayImpl implements ExternalPayAPI {

    @Override
    public boolean processPay(long price) {
        return requestPay() && approvePay();
    }

    private boolean requestPay() {
        return true;
    }

    private boolean approvePay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
