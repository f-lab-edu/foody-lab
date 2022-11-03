package app.foodylab.domain.customer;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Customer {

    private final long id;
    private final String name;
}
