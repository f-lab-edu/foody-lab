package app.foodylab;

import app.foodylab.user.User;

public class UserFixture {

    public static User createUser() {
        return new User(
                "tottenham7",
                "son heung min"
        );
    }
}
