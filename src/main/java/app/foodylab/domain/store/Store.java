package app.foodylab.domain.store;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Store {

    private final long id;
    private final String name;
    private final StoreState storeState;
    private final long minimumOrderPrice;
}
