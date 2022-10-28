package app.foodylab;

import app.foodylab.application.user.dto.UserDTO;
import app.foodylab.domain.user.User;

public class UserFixture {

    public static final User USER = new User(
        1,
        "heung min son"
    );

    public static final UserDTO USER_DTO = new UserDTO(
        "heung min son"
    );
}
