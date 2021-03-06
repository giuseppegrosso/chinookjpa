package it.plansoft.chinookjpa.service;/* ggrosso created on 27/02/2021 inside the package - it.plansoft.chinookjpa.service */

import it.plansoft.chinookjpa.model.Employee;
import it.plansoft.chinookjpa.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService extends BaseCrudService<EmployeeRepository, Employee, Long> {

    public EmployeeService(EmployeeRepository repository) {
        super(repository);
    }
}