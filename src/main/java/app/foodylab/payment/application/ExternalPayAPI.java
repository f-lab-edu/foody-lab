package app.foodylab.payment.application;

public interface ExternalPayAPI {
    boolean processPay(long price);
}