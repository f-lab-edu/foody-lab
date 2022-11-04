package app.foodylab.adaptor.payment;

import app.foodylab.application.payment.ExternalPayAPI;
import app.foodylab.domain.order.Order;
import java.time.LocalDate;

public class ExternalKakaoPayImpl implements ExternalPayAPI {

    @Override
    public boolean processPay(Order order) {
        KakaoPayResp kakaoPayResp = approvePay(order);
        String responseCode = kakaoPayResp.getResponseCode();
        return requestPay() && isApproved(responseCode);
    }

    private boolean isApproved(String responseCode) {
        return "200".equals(responseCode);
    }

    private boolean requestPay() {
        return true;
    }

    private KakaoPayResp approvePay(Order order) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        LocalDate now = LocalDate.now();
        return new KakaoPayResp("200", order.getOrderPrice(), "id", now, now);
    }
}
