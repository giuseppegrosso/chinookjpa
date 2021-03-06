package it.plansoft.chinookjpa.model;/* ggrosso created on 27/02/2021 inside the package - it.plansoft.chinookjpa.model */

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "Albums")
@Table(name = "albums", uniqueConstraints = { @UniqueConstraint(name = "albums_title_unique", columnNames = "title") })
@Data
public class Albums extends BaseId<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artists artist;

    @OneToMany(cascade= CascadeType.ALL, mappedBy="album")
    private Set<Tracks> tracks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artists getArtist() {
        return artist;
    }

    public void setArtist(Artists artist) {
        this.artist = artist;
    }

    public Albums() {

    }

    public Albums(Long id, String title, Artists artist) {
        this.id = id;
        this.title = title;
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Albums{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", artist=" + artist +
                ", tracks=" + tracks +
                '}';
    }
}
