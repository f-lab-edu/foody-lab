package app.foodylab.application.payment;

import app.foodylab.domain.order.Order;

public interface PayMethod {

    String getMethod();

    boolean pay(Order order);
}
