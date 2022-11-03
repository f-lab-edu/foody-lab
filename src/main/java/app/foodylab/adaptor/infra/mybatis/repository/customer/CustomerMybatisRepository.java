package app.foodylab.adaptor.infra.mybatis.repository.customer;

import app.foodylab.adaptor.infra.mapper.CustomerMapper;
import app.foodylab.domain.customer.Customer;
import app.foodylab.domain.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
@RequiredArgsConstructor
public class CustomerMybatisRepository implements CustomerRepository {

    private final CustomerMapper dao;

    @Override
    public void insertCustomer(Customer customer) {
        dao.insertCustomer(customer);
    }
}
