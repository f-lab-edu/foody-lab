package app.foodylab.domain.payment;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class PayApproveResponse {
    private final String id;
    private final String storeCode;
    private final String transactionId;
    private final String orderId;
    private final String storeId;
}
