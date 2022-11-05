package app.foodylab.domain.payment;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
public class PayReadyRequest {
    private final long price;
    private String approvelUrl = "/approve";
    private String cancelUrl = "/cancel";
    private String failUrl = "/fail";
    private final String storeId;
    private final String orderId;

    public void setToken(String token) {
        approvelUrl += token;
        cancelUrl += token;
        failUrl += token;
    }
}
