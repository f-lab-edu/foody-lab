package app.foodylab.payment.adapter;

import app.foodylab.payment.application.ExternalPayAPI;

public class ExternalKakaoPayImpl implements ExternalPayAPI {

    @Override
    public boolean processPay(long price) {
        return true;
    }
}
