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
        // todo: transactionId 이거는 외부 페이서비스에서 주는 아이디, 랜덤으로 만들까 고민중...
        return new PayReadyResponse("transactionId", "/kakaopay", LocalDate.now());
    }

    @Override
    public PayApproveResponse approvePay(PayApproveRequest request) {
        // todo: requestId 요청고유번호의 역할은..?
        return new PayApproveResponse("requestId", "transactionId", "orderId", "storeId");
    }
}
