package app.foodylab;

import app.foodylab.domain.store.Store;
import app.foodylab.domain.store.StoreState;

public class StoreFixture {

    public static Store STORE = new Store(
        1,
        "BAQ",
        StoreState.valueOf("OPEN"),
        15000L
    );
}
