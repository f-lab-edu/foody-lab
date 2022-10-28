package app.foodylab.domain.store;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum StoreState {
    OPEN("OPEN"),
    CLOSED("CLOSED"),
    BREAK_TIME("BREAK_TIME"),
    CLOSED_BUSINESS("CLOSED_BUSINESS");

    private final String value;
}
