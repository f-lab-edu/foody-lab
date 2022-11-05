package app.foodylab.adaptor.payment;

import app.foodylab.application.payment.ExternalPayApi;
import app.foodylab.application.payment.PayMethod;
import app.foodylab.domain.payment.PayApproveRequest;
import app.foodylab.domain.payment.PayApproveResponse;
import app.foodylab.domain.payment.PayReadyRequest;
import app.foodylab.domain.payment.PayReadyResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KakaoPay implements PayMethod {

    private final Logger logger = LoggerFactory.getLogger(KakaoPay.class);
    private final ExternalPayApi payApi = new ExternalKakaoPayImpl();

    @Override
    public String getMethod() {
        return "kakaoPay";
    }

    @Override
    public boolean pay(PayReadyRequest readyRequest) {
        PayReadyResponse payReadyResponse = payApi.readyPay(readyRequest);
        String transactionId = payReadyResponse.getTransactionId();
        PayApproveRequest approveRequest = new PayApproveRequest(readyRequest.getOrderId(), readyRequest.getStoreId(), transactionId);
        PayApproveResponse payApproveResponse = payApi.approvePay(approveRequest);
        return true;
    }
}
