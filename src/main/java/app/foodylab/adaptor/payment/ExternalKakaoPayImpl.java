package app.foodylab.adaptor.payment;

import app.foodylab.application.payment.ExternalPayApi;
import app.foodylab.domain.payment.PayApproveRequest;
import app.foodylab.domain.payment.PayApproveResponse;
import app.foodylab.domain.payment.PayReadyRequest;
import app.foodylab.domain.payment.PayReadyResponse;
import java.time.LocalDate;

public class ExternalKakaoPayImpl implements ExternalPayApi {

    @Override
    public PayReadyResponse readyPay(PayReadyRequest payReady) {
        return new PayReadyResponse("transactionId", "nextUrl", LocalDate.now());
    }

    @Override
    public PayApproveResponse approvePay(PayApproveRequest request) {
        return new PayApproveResponse("requestId", "transactionId", "orderId", "storeId");
    }
}
