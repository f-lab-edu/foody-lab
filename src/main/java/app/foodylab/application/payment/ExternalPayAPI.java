package app.foodylab.application.payment;

import app.foodylab.domain.order.Order;

public interface ExternalPayAPI {

    boolean processPay(Order order);
}