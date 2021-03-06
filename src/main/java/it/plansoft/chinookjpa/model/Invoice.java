package it.plansoft.chinookjpa.model;/* ggrosso created on 05/03/2021 inside the package - it.plansoft.chinookjpa.model */

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity(name = "Invoices")
@Table(name = "invoices")
@Data
public class Invoice extends BaseId<Long> {

    @Id
    @Column(name = "invoice_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    @OneToMany(cascade= CascadeType.ALL, mappedBy="invoice")
    @JsonIgnore
    private Set<InvoiceItem> invoiceItems;

    @ManyToOne
    @JoinColumn( name="customer_id" , nullable = false)
    private Customer customer;

    @Column(name = "invoice_date", nullable = false)
    private String localDateTime;

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

    public Invoice() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<InvoiceItem> getInvoiceItems() {
        return invoiceItems;
    }

    public void setInvoiceItems(Set<InvoiceItem> invoiceItems) {
        this.invoiceItems = invoiceItems;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(String localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    public String getBillingState() {
        return billingState;
    }

    public void setBillingState(String billingState) {
        this.billingState = billingState;
    }

    public String getBillingCountry() {
        return billingCountry;
    }

    public void setBillingCountry(String billingCountry) {
        this.billingCountry = billingCountry;
    }

    public String getBillingPostalCode() {
        return billingPostalCode;
    }

    public void setBillingPostalCode(String billingPostalCode) {
        this.billingPostalCode = billingPostalCode;
    }

    public Double getTotale() {
        return totale;
    }

    public void setTotale(Double totale) {
        this.totale = totale;
    }
}
