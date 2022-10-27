package app.foodylab.user.adapter;

import app.foodylab.user.domain.User;
import app.foodylab.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public void saveUser(@RequestBody User user) {
        userService.saveUser(user);
    }
}
