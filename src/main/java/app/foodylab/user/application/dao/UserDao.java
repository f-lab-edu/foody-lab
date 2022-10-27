package app.foodylab.user.application.dao;

import app.foodylab.user.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {

    void userInsert(@Param("user") User user);
}