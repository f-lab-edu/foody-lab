package app.foodylab;

import app.foodylab.Store.Store;
import app.foodylab.Store.StoreState;

public class StoreFixture {

    public static Store createStore() {
        return new Store(
                "BAQ",
                StoreState.OPEN,
                7000L
        );
    }
}
