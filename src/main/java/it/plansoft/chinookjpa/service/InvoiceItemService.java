package it.plansoft.chinookjpa.service;/* ggrosso created on 27/02/2021 inside the package - it.plansoft.chinookjpa.service */

import it.plansoft.chinookjpa.model.InvoiceItem;
import it.plansoft.chinookjpa.repository.InvoiceItemRepository;
import org.springframework.stereotype.Service;

@Service
public class InvoiceItemService extends BaseCrudService<InvoiceItemRepository, InvoiceItem, Long> {

    public InvoiceItemService(InvoiceItemRepository repository) {
        super(repository);
    }
}