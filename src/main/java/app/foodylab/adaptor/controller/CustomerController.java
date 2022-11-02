package app.foodylab.adaptor.controller;

import app.foodylab.application.customer.service.CustomerService;
import app.foodylab.domain.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customer")
    public void saveCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
    }
}
