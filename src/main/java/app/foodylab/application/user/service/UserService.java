package app.foodylab.application.user.service;

import app.foodylab.domain.user.User;
import app.foodylab.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.userInsert(user);
    }

}
