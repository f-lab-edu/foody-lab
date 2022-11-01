package app.foodylab.adaptor.infra.mybatis.repository.user;

import app.foodylab.adaptor.infra.mapper.UserMapper;
import app.foodylab.domain.user.User;
import app.foodylab.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
@RequiredArgsConstructor
public class UserMybatisRepository implements UserRepository {

    private final UserMapper dao;

    @Override
    public void userInsert(User user) {
        dao.userInsert(user);
    }
}
