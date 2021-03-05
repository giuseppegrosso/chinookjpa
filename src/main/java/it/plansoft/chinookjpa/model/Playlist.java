package it.plansoft.chinookjpa.model;/* ggrosso created on 28/02/2021 inside the package - it.plansoft.chinookjpa.model */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@ToString
@Entity
@Table(name = "playlists")
public class Playlist extends BaseId<Long> {

    @Id
    @Column(name = "playlist_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="playlist_track",
            joinColumns=@JoinColumn(name="playlist_id", referencedColumnName="playlist_id"),
            inverseJoinColumns=@JoinColumn(name="track_id", referencedColumnName="track_id"))
    private Set<Tracks> tracks;

    public Playlist() {
    }


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

    public Set<Tracks> getTracks() {
        return tracks;
    }

    public void setTracks(Set<Tracks> tracks) {
        this.tracks = tracks;
    }
}
