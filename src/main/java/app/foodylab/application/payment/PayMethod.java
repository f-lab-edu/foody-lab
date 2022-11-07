package app.foodylab.application.payment;

import app.foodylab.domain.payment.PayApproveResponse;
import app.foodylab.domain.payment.PayReadyRequest;

public interface PayMethod {

    String getMethod();

    PayApproveResponse pay(PayReadyRequest request);
}
