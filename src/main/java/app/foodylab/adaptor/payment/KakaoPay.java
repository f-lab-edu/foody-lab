package app.foodylab.adaptor.payment;

import app.foodylab.application.payment.ExternalPayApi;
import app.foodylab.application.payment.PayMethod;
import app.foodylab.domain.payment.PayApproveRequest;
import app.foodylab.domain.payment.PayApproveResponse;
import app.foodylab.domain.payment.PayReadyRequest;
import app.foodylab.domain.payment.PayReadyResponse;

public class KakaoPay implements PayMethod {

    private final ExternalPayApi payApi = new ExternalKakaoPayImpl();

    @Override
    public String getMethod() {
        return "kakaoPay";
    }

    @Override
    public PayApproveResponse pay(PayReadyRequest readyRequest) {
        PayReadyResponse payReadyResponse = getPayReadyResponse(readyRequest);
        PayApproveRequest approveRequest = getPayApproveRequest(readyRequest, payReadyResponse);
        return getPayApproveResponse(approveRequest);
    }

    private PayReadyResponse getPayReadyResponse(PayReadyRequest readyRequest) {
        return payApi.readyPay(readyRequest);
    }

    private PayApproveRequest getPayApproveRequest(PayReadyRequest readyRequest,
        PayReadyResponse payReadyResponse) {
        return PayApproveRequest.of(readyRequest, payReadyResponse);
    }

    private PayApproveResponse getPayApproveResponse(PayApproveRequest approveRequest) {
        PayApproveResponse payApproveResponse = payApi.approvePay(approveRequest);
        return payApproveResponse;
    }
}
