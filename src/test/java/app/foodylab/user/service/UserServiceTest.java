package app.foodylab.user.service;

import app.foodylab.UserFixture;
import app.foodylab.adaptor.mapper.UserMapper;
import app.foodylab.application.user.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest {

//    private final UserMapper userRepository = mock(UserMapper.class);
//    private final UserService userService = new UserService(userRepository);

    @Autowired
    private UserMapper userRepository;

    @Test
    @DisplayName("유저 저장 테스트")
    void test1() {
        UserService userService = new UserService(userRepository);
        userService.saveUser(UserFixture.USER);
//        userService.saveUser(UserFixture.USER);
//        verify(userRepository, times(1)).userInsert(UserFixture.USER);
    }

}
