package it.plansoft.chinookjpa.controller;/* ggrosso created on 05/03/2021 inside the package - it.plansoft.chinook.controller */

import it.plansoft.chinookjpa.model.Customer;
import it.plansoft.chinookjpa.repository.CustomerRepository;
import it.plansoft.chinookjpa.service.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController extends BaseCrudController<CustomerService, CustomerRepository, Customer, Long> {

    public CustomerController(CustomerService service) {
        super(service);
    }

}