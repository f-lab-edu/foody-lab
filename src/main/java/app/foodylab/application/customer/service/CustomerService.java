package app.foodylab.application.customer.service;

import app.foodylab.domain.customer.Customer;
import app.foodylab.domain.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public void saveCustomer(Customer customer) {
        customerRepository.insertCustomer(customer);
    }

}
