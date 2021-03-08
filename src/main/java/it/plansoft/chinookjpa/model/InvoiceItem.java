package it.plansoft.chinookjpa.model;/* ggrosso created on 05/03/2021 inside the package - it.plansoft.chinookjpa.model */

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity(name = "Invoice_item")
@Table(name = "invoice_items")
@Data
@NoArgsConstructor
public class InvoiceItem extends BaseId<Long> {

    @Id
    @Column(name = "invoice_line_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "track_id")
    @JsonIgnore
    private Tracks tracks;

    @Column(name = "unit_price")
    private Double unitPrice;

    @Column(name = "quantity")
    private Double quantity;


}
