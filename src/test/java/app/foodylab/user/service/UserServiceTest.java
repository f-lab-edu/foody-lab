package app.foodylab.user.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import app.foodylab.UserFixture;
import app.foodylab.user.adapter.infra.mybatis.UserMybatisRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserServiceTest {

    private final UserMybatisRepository userRepository = mock(UserMybatisRepository.class);
    private final UserService userService = new UserService(userRepository);

    @Test
    @DisplayName("유저 저장 테스트")
    void test1() {
        userService.saveUser(UserFixture.USER);
        verify(userRepository, times(1)).insert(UserFixture.USER);
    }

}
