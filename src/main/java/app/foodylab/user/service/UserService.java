package app.foodylab.user.service;

import app.foodylab.user.application.repository.UserRepository;
import app.foodylab.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.insert(user);
    }

}