package app.foodylab.application;

import app.foodylab.adaptor.CustomerDto;
import app.foodylab.domain.customer.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    Customer toUser(CustomerDto customerDto);
}
