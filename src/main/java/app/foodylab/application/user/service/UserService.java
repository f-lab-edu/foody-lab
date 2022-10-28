package app.foodylab.application.user.service;

import app.foodylab.adaptor.mapper.UserMapper;
import app.foodylab.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userRepository;

    public void saveUser(User user) {
        userRepository.userInsert(user);
    }

}
