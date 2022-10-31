package app.foodylab.user.adapter;

import app.foodylab.user.adapter.dto.UserDTO;
import app.foodylab.user.domain.User;
import app.foodylab.user.service.UserService;
import app.foodylab.user.utils.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public void saveUser(@RequestBody UserDTO userDTO) {
        User user = UserMapper.INSTANCE.toUser(userDTO);
        userService.saveUser(user);
    }
}
