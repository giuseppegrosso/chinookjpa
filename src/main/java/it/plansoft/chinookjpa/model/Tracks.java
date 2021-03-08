package it.plansoft.chinookjpa.model;/* ggrosso created on 28/02/2021 inside the package - it.plansoft.chinookjpa.model */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@Entity
@Table(name = "tracks")
@NoArgsConstructor
public class Tracks extends BaseId<Long> {

    @Id
    @Column(name = "track_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Albums album;

    @ManyToOne
    @JoinColumn(name = "media_type_id")
    private MediaTypes mediaTypes;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genres genres;


    @OneToMany(mappedBy = "invoice")
    private Set<InvoiceItem> invoiceItems;

    @Column(name = "composer")
    private String composer;

    @Column(name = "milliseconds")
    private Long milliseconds;

    @Column(name = "bytes")
    private Long bytes;

    @Column(name = "unitprice")
    private Double unitPrice;

}
