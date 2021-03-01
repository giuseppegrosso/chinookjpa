package it.plansoft.chinookjpa.model;/* ggrosso created on 27/02/2021 inside the package - it.plansoft.chinookjpa.model */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "albums")
public class Albums extends BaseId<Long>
{

    @Id
    @Column(name = "album_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "title")
    private String title;


    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artists artist;

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

    public Albums()
    {

    }

    public Albums(Long id, String title, Artists artist) {
        this.id = id;
        this.title = title;
        this.artist = artist;
    }
}
