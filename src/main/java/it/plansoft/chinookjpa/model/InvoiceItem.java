package it.plansoft.chinookjpa.model;/* ggrosso created on 05/03/2021 inside the package - it.plansoft.chinookjpa.model */

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;


@Entity(name = "Invoice_item")
@Table(name = "invoice_items")
@Data
public class InvoiceItem extends BaseId<Long> {

    @Id
    @Column(name = "invoice_line_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn( name="invoice_id" )
    private Invoice invoice;

    @ManyToOne(cascade = CascadeType.ALL)
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

    public InvoiceItem() {
    }

    public InvoiceItem(Long id, Invoice invoice, Tracks tracks, Double unitPrice, Double quantity) {
        this.id = id;
        this.invoice = invoice;
        this.tracks = tracks;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "InvoiceItem{" +
                "id=" + id +
                ", invoice=" + invoice +
                ", tracks=" + tracks +
                ", unitPrice=" + unitPrice +
                ", quantity=" + quantity +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Tracks getTracks() {
        return tracks;
    }

    public void setTracks(Tracks tracks) {
        this.tracks = tracks;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
