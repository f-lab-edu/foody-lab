package app.foodylab.Store;

public enum StoreState {
    OPEN("Y"),
    CLOSED("N")
    ;

    private final String value;

    StoreState(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
