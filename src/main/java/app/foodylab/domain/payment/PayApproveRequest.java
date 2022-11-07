package app.foodylab.domain.payment;

public class PayApproveRequest {
    private final String orderId;
    private final String storeId;
    private final String transactionId;

    private PayApproveRequest(String orderId, String storeId, String transactionId) {
        this.orderId = orderId;
        this.storeId = storeId;
        this.transactionId = transactionId;
    }

    public static PayApproveRequest of(PayReadyRequest request, PayReadyResponse response) {
        return new PayApproveRequest(request.getOrderId(), request.getStoreId(), response.getTransactionId());
    }
}
