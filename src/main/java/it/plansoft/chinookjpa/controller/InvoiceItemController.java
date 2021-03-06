package it.plansoft.chinookjpa.controller;/* ggrosso created on 05/03/2021 inside the package - it.plansoft.chinook.controller */

import it.plansoft.chinookjpa.model.InvoiceItem;
import it.plansoft.chinookjpa.repository.InvoiceItemRepository;
import it.plansoft.chinookjpa.service.InvoiceItemService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoiceitem")
public class InvoiceItemController extends BaseCrudController<InvoiceItemService, InvoiceItemRepository, InvoiceItem, Long> {

    public InvoiceItemController(InvoiceItemService service) {
        super(service);
    }

}