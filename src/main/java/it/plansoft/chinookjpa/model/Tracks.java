package it.plansoft.chinookjpa.model;/* ggrosso created on 28/02/2021 inside the package - it.plansoft.chinookjpa.model */

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "album_id")
    private Albums album;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "media_type_id")
    private MediaTypes mediaTypes;

    @ManyToOne(fetch= FetchType.LAZY)
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
