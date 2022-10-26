package app.foodylab.payment.adapter;

import app.foodylab.payment.application.PayMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KakaoPay implements PayMethod {

    private final Logger logger = LoggerFactory.getLogger(KakaoPay.class);
    @Override
    public String getMethod() {
        return "kakaoPay";
    }

    @Override
    public void pay(Long price) {
        if (logger.isInfoEnabled()) {
            logger.info("카카오페이로 {}원이 결제되었습니다.", price);
        }
    }
}
