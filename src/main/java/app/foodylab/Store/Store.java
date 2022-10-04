package app.foodylab.Store;

import lombok.Getter;

@Getter
public class Store {

    private final String id;
    private final String name;
    private final StoreState storeState;
    private final long minimumOrderAmount;

    public Store(String id, String name, StoreState storeState, long minimumOrderAmount) {
        this.id = id;
        this.name = name;
        this.storeState = storeState;
        this.minimumOrderAmount = minimumOrderAmount;
    }
}
