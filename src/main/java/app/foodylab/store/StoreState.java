package app.foodylab.store;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum StoreState {
    OPEN("OPEN"),
    CLOSED("CLOSE");

    private final String value;
}
