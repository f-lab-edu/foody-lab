package app.foodylab;

import app.foodylab.Store.Store;
import app.foodylab.Store.StoreState;

public class StoreFixture {
    public static Store STORE = new Store(
            "BAQ",
            StoreState.OPEN,
            15000L
    );
}
