package it.plansoft.chinookjpa.repository;/* ggrosso created on 06/03/2021 inside the package - it.plansoft.chinookjpa.repository */

import it.plansoft.chinookjpa.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
