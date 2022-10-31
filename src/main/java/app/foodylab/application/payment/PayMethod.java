package app.foodylab.application.payment;

public interface PayMethod {

    String getMethod();

    boolean pay(long amount);
}
