package it.plansoft.chinookjpa.service;/* ggrosso created on 27/02/2021 inside the package - it.plansoft.chinookjpa.service */

import it.plansoft.chinookjpa.model.Invoice;
import it.plansoft.chinookjpa.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService extends BaseCrudService<InvoiceRepository, Invoice, Long> {

    public InvoiceService(InvoiceRepository repository) {
        super(repository);
    }
}