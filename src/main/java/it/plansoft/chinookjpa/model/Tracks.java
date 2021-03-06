package it.plansoft.chinookjpa.model;/* ggrosso created on 28/02/2021 inside the package - it.plansoft.chinookjpa.model */

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tracks")
public class Tracks extends BaseId<Long> {

    public Tracks() {
    }

    @Id
    @Column(name = "track_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn( name="album_id" )
    private Albums album;

    @ManyToOne
    @JoinColumn( name="media_type_id" )
    private MediaTypes mediaTypes;

    @ManyToOne
    @JoinColumn( name="genre_id" )
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

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Albums getAlbum() {
        return album;
    }

    public void setAlbum(Albums album) {
        this.album = album;
    }

    public MediaTypes getMediaTypes() {
        return mediaTypes;
    }

    public void setMediaTypes(MediaTypes mediaTypes) {
        this.mediaTypes = mediaTypes;
    }

    public Genres getGenres() {
        return genres;
    }

    public void setGenres(Genres genres) {
        this.genres = genres;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public Long getMilliseconds() {
        return milliseconds;
    }

    public void setMilliseconds(Long milliseconds) {
        this.milliseconds = milliseconds;
    }

    public Long getBytes() {
        return bytes;
    }

    public void setBytes(Long bytes) {
        this.bytes = bytes;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
