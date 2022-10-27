package app.foodylab.payment.application;

public interface PayMethod {
    String getMethod();
    boolean pay(long amount);
}
