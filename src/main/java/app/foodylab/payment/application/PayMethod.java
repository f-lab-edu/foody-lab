package app.foodylab.payment.application;

public interface PayMethod {
    String getMethod();
    void pay(Long amount);
}
