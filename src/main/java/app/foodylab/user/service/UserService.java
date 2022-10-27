package app.foodylab.user.service;

import app.foodylab.user.adapter.infra.mybatis.UserMybatisRepository;
import app.foodylab.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMybatisRepository userRepository;

    public void saveUser(User user) {
        userRepository.insert(user);
    }

}
