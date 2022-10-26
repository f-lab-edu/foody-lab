package app.foodylab.user.service;

import app.foodylab.user.application.repository.UserRepository;
import app.foodylab.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.insert(user);
    }

}
