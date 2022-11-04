package app.foodylab.adaptor.controller;

import app.foodylab.application.customer.service.CustomerService;
import app.foodylab.domain.customer.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/customer")
    public void saveCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
    }
}
