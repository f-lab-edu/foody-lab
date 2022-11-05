package app.foodylab.domain.payment;

import app.foodylab.domain.order.Order;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class PayReadyRequest {
    private final long price;
    private final String storeId;
    private final String orderId;
    private String approvelUrl = "/approve";
    private String cancelUrl = "/cancel";
    private String failUrl = "/fail";

    private PayReadyRequest(long price, String storeId, String orderId) {
        this.price = price;
        this.storeId = storeId;
        this.orderId = orderId;
    }

    private void setToken(final String token) {
        approvelUrl += token;
        cancelUrl += token;
        failUrl += token;
    }

    public static PayReadyRequest of(final long price, final Order order) {
        PayReadyRequest request = new PayReadyRequest(price, order.getStoreId(), order.getId());
        request.setToken(order.getId());
        return request;
    }
}
