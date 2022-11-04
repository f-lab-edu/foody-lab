package app.foodylab.user.utils;

import app.foodylab.user.adapter.dto.UserDTO;
import app.foodylab.user.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toUser(UserDTO userDTO);
}
