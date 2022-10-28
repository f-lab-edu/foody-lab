package app.foodylab.adaptor.controller;

import app.foodylab.application.user.service.UserService;
import app.foodylab.domain.user.User;
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
