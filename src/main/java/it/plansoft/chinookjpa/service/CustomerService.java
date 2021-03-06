package it.plansoft.chinookjpa.service;/* ggrosso created on 27/02/2021 inside the package - it.plansoft.chinookjpa.service */

import it.plansoft.chinookjpa.model.Customer;
import it.plansoft.chinookjpa.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends BaseCrudService<CustomerRepository, Customer, Long> {

    public CustomerService(CustomerRepository repository) {
        super(repository);
    }
}