package it.plansoft.chinookjpa.controller;/* ggrosso created on 05/03/2021 inside the package - it.plansoft.chinook.controller */

import it.plansoft.chinookjpa.model.Employee;
import it.plansoft.chinookjpa.repository.EmployeeRepository;
import it.plansoft.chinookjpa.service.EmployeeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController extends BaseCrudController<EmployeeService, EmployeeRepository, Employee, Long> {

    public EmployeeController(EmployeeService service) {
        super(service);
    }

}