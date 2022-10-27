package app.foodylab.user.application.repository;

import app.foodylab.user.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRepository {

    @Insert("insert into user(id, name) values(#{user.id}, #{user.name})")
    void insert(@Param("user") User user);
}
