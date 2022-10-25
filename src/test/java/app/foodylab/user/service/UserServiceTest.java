package app.foodylab.user.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import app.foodylab.UserFixture;
import app.foodylab.user.application.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserServiceTest {

    private final UserRepository userRepository = mock(UserRepository.class);
    private final UserService userService = new UserService(userRepository);

    @Test
    @DisplayName("유저 저장 테스트")
    void test1() {
        userService.saveUser(UserFixture.USER);
        verify(userRepository, times(1)).insert(UserFixture.USER);
    }

}
