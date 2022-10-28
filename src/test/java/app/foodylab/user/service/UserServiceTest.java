package app.foodylab.user.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import app.foodylab.UserFixture;
import app.foodylab.adaptor.mapper.UserMapper;
import app.foodylab.application.user.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserServiceTest {

    private final UserMapper userRepository = mock(UserMapper.class);
    private final UserService userService = new UserService(userRepository);

    @Test
    @DisplayName("유저 저장 테스트")
    void test1() {
        userService.saveUser(UserFixture.USER);
        verify(userRepository, times(1)).userInsert(UserFixture.USER);
    }

}
