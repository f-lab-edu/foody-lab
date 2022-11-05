package app.foodylab.domain.payment;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
public class PayReadyRequest {
    private final long price;
    private final String approvalUrl;
    private final String cancelUrl;
    private final String failUrl;
    private final String storeCode;
    private final String storeId;
    private final String orderId;
}
