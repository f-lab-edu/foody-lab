package app.foodylab.application.payment;

import app.foodylab.domain.payment.PayApproveRequest;
import app.foodylab.domain.payment.PayApproveResponse;
import app.foodylab.domain.payment.PayReadyRequest;
import app.foodylab.domain.payment.PayReadyResponse;

public interface ExternalPayApi {

    PayReadyResponse readyPay(PayReadyRequest request);
    PayApproveResponse approvePay(PayApproveRequest request);
}