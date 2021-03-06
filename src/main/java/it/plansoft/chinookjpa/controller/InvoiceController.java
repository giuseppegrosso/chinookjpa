package it.plansoft.chinookjpa.controller;/* ggrosso created on 05/03/2021 inside the package - it.plansoft.chinook.controller */

import it.plansoft.chinookjpa.model.Invoice;
import it.plansoft.chinookjpa.repository.InvoiceRepository;
import it.plansoft.chinookjpa.service.InvoiceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoice")
public class InvoiceController extends BaseCrudController<InvoiceService, InvoiceRepository, Invoice, Long> {

    public InvoiceController(InvoiceService service) {
        super(service);
    }

}