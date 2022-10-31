package app.foodylab.application.payment;

public interface ExternalPayAPI {

    boolean processPay(long price);
}