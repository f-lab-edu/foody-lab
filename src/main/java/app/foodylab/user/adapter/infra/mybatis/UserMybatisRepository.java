package app.foodylab.user.adapter.infra.mybatis;

import app.foodylab.user.application.repository.UserDao;
import app.foodylab.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMybatisRepository {

    private final UserDao dao;

    public void insert(User user) {
        dao.userInsert(user);
    }
}
