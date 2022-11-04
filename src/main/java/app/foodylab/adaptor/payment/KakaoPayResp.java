package app.foodylab.adaptor.payment;

import java.time.LocalDate;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class KakaoPayResp {

    private final String responseCode;
    private final long price;
    private final String orderId;
    private final LocalDate createdAt;
    private final LocalDate approvedAt;

}
