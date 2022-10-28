package app.foodylab.adaptor.infra.mybatis.repository.user;

import app.foodylab.adaptor.mapper.UserMapper;
import app.foodylab.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
@RequiredArgsConstructor
public class UserMybatisRepository implements UserMapper {

    private final UserMapper dao;

    @Override
    public void userInsert(User user) {
        dao.userInsert(user);
    }
}
