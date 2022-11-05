package app.foodylab.domain.payment;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class PayApproveRequest {
    private final String orderId;
    private final String storeId;
    private final String transactionId;
}
