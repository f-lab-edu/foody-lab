package app.foodylab.application.customer;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import app.foodylab.CustomerFixture;
import app.foodylab.application.customer.service.CustomerService;
import app.foodylab.domain.customer.repository.CustomerRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomerServiceTest {

    private final CustomerRepository customerRepository = mock(CustomerRepository.class);
    private final CustomerService customerService = new CustomerService(customerRepository);

    @Test
    @DisplayName("고객 저장 테스트")
    void test1() {
        customerService.saveCustomer(CustomerFixture.CUSTOMER);
        verify(customerRepository, times(1)).insertCustomer(CustomerFixture.CUSTOMER);
    }

}
