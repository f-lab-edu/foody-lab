package app.foodylab.domain.store;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum StoreState {
    OPEN,
    CLOSED,
    BREAK_TIME,
    CLOSED_BUSINESS
}
