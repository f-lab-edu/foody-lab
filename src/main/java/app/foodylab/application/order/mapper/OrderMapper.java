package app.foodylab.application.order.mapper;

import app.foodylab.application.dto.OrderDto;
import app.foodylab.domain.order.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order toOrder(OrderDto orderDTO);
}
