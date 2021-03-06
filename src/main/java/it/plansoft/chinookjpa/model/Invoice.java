package it.plansoft.chinookjpa.model;/* ggrosso created on 05/03/2021 inside the package - it.plansoft.chinookjpa.model */

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity(name = "Invoices")
@Table(name = "invoices")
@Data
public class Invoice extends BaseId<Long> {

    @Id
    @Column(name = "invoices_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    @OneToMany(mappedBy = "invoice")
    private Set<InvoiceItem> invoiceItems;

    @ManyToOne
    @JoinColumn( name="customer_id" , nullable = false)
    private Customer customer;

    @Column(name = "invoice_date", nullable = false)
    private LocalDateTime localDateTime;

    @Column(name = "billing_address")
    private String billingAddress;

    @Column(name = "billing_city")
    private String billingCity;

    @Column(name = "billing_state")
    private String billingState;

    @Column(name = "billing_country")
    private String billingCountry;

    @Column(name = "billing_postal_code")
    private String billingPostalCode;

    @Column(name = "total")
    private Double totale;


}
