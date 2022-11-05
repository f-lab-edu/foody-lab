package app.foodylab.application.payment;

import app.foodylab.domain.payment.PayReadyRequest;

public interface PayMethod {

    String getMethod();

    boolean pay(PayReadyRequest request);
}
