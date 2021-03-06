package it.plansoft.chinookjpa.repository;/* ggrosso created on 06/03/2021 inside the package - it.plansoft.chinookjpa.repository */

import it.plansoft.chinookjpa.model.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Long> {

}
