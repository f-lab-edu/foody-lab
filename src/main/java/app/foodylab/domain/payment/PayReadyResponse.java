package app.foodylab.domain.payment;

import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
public class PayReadyResponse {
    private final String transactionId;
    private final String nextUrl;
    private final LocalDate createdAt;
}
