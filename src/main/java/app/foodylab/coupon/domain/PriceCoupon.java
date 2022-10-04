package app.foodylab.coupon.domain;

import java.time.LocalDate;

public class PriceCoupon {

    private final int saledPrice;
    private final LocalDate startDate;
    private final LocalDate endDate;


    public PriceCoupon(int saledPrice, LocalDate startDate, LocalDate endDate) {
        this.saledPrice = saledPrice;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getSaledPrice() {
        return saledPrice;
    }

    public static PriceCoupon of(int saledPrice) {
        isNegative(saledPrice);
        return of(saledPrice, LocalDate.now(), LocalDate.now().plusYears(1));
    }

    public static PriceCoupon of(int saledPrice, LocalDate startDate, LocalDate endDate) {
        isNegative(saledPrice);
        isValidStartDate(startDate);
        isValidEndDate(endDate);
        isValidDate(startDate, endDate);
        return new PriceCoupon(saledPrice, startDate, endDate);
    }

    private static void isValidDate(LocalDate startDate, LocalDate endDate) {
        if (endDate.isBefore(startDate)) throw new IllegalArgumentException("쿠폰 사용 종료일은 시작일 이전일 수 없습니다.");
    }

    private static void isValidEndDate(LocalDate endDate) {
        if (endDate.isBefore(LocalDate.now())) throw new IllegalArgumentException("쿠폰 사용 종료일은 현재보다 이전일 수 없습니다.");
    }

    private static void isValidStartDate(LocalDate startDate) {
        if (startDate.isBefore(LocalDate.now())) throw new IllegalArgumentException("쿠폰 사용 시작일은 현재보다 이전일 수 없습니다.");
    }

    private static void isNegative(int saledPrice) {
        if (saledPrice <= 0) throw  new IllegalArgumentException("할인 금액은 0보다 커야 합니다.");
    }
}
