package it.plansoft.chinookjpa.model;/* ggrosso created on 27/02/2021 inside the package - it.plansoft.chinookjpa.model */

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor

@ToString
@Entity
@Table(name = "artists")
public class Artists extends BaseId<Long> {
    @Id
    @Column(name = "artist_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "Name")
    private String name;


    @OneToMany(mappedBy = "artist")
    @JsonIgnore
    private Set<Albums> albums;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Albums> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Albums> albums) {
        this.albums = albums;
    }


    public Artists() {
    }

    public Artists(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
