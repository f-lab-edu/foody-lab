package app.foodylab;

import app.foodylab.store.Store;
import app.foodylab.store.StoreState;

public class StoreFixture {

    public static Store STORE = new Store(
        "BAQ",
        StoreState.OPEN,
        15000L
    );
}
