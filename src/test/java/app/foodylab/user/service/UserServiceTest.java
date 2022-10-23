package app.foodylab.user.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import app.foodylab.UserFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserServiceTest {

    UserService userService = mock(UserService.class);

    @Test
    @DisplayName("유저 저장 테스트")
    void test1() {
        userService.saveUser(UserFixture.USER);
        verify(userService, times(1)).saveUser(UserFixture.USER);
    }

}
