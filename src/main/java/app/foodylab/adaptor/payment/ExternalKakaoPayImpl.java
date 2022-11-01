package app.foodylab.adaptor.payment;

import app.foodylab.application.payment.ExternalPayAPI;

public class ExternalKakaoPayImpl implements ExternalPayAPI {

    @Override
    public boolean processPay(long price) {
        boolean canPay = requestPay();
        if (Boolean.FALSE.equals(canPay)) {
            return false;
        }
        approvePay();
        return true;
    }

    private boolean requestPay() {
        return true;
    }

    private void approvePay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
