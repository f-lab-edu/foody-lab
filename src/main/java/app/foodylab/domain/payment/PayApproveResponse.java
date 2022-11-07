package app.foodylab.domain.payment;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
public class PayApproveResponse {
    private final String id;
    private final String transactionId;
    private final String orderId;
    private final String storeId;
}
