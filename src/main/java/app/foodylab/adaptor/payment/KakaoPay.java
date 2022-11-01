package app.foodylab.adaptor.payment;

import app.foodylab.application.payment.ExternalPayAPI;
import app.foodylab.application.payment.PayMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KakaoPay implements PayMethod {

    private final Logger logger = LoggerFactory.getLogger(KakaoPay.class);
    private final ExternalPayAPI payAPI = new ExternalKakaoPayImpl();

    @Override
    public String getMethod() {
        return "kakaoPay";
    }

    @Override
    public boolean pay(long price) {
        boolean isPaid = payAPI.processPay(price);
        if (isPaid && logger.isInfoEnabled()) {
            logger.info("카카오페이로 {}원이 결제되었습니다.", price);
        }
        return isPaid;
    }
}
