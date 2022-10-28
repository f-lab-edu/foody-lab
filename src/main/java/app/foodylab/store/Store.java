package app.foodylab.store;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Store {

    private final String name;
    private final StoreState storeState;
    private final long minimumOrderPrice;
}
