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
    public void pay(Long amount) {
        if (logger.isInfoEnabled()) {
            logger.info(String.format("카카오페이로 %d원이 결제되었습니다.", amount));
        }
    }
}
