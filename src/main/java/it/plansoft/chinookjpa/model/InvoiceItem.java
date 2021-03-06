package it.plansoft.chinookjpa.model;/* ggrosso created on 05/03/2021 inside the package - it.plansoft.chinookjpa.model */

import lombok.Data;

import javax.persistence.*;


@Entity(name = "Invoices_item")
@Table(name = "invoices_items")
@Data
public class InvoiceItem extends BaseId<Long> {

    @Id
    @Column(name = "invoices_item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch= FetchType.LAZY)
    @JoinColumn( name="invoice_id" )
    private Invoice invoice;

    @ManyToOne(cascade = CascadeType.ALL, fetch= FetchType.LAZY)
    @JoinColumn( name="track_id" )
    private Tracks tracks;

    @Column(name = "unit_price")
    private Double unitPrice;

    @Column(name = "quantity")
    private Double quantity;


    @Override
    public Long getId() {
        return id;
    }
}
