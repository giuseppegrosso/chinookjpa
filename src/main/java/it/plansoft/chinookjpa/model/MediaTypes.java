package it.plansoft.chinookjpa.model;/* ggrosso created on 28/02/2021 inside the package - it.plansoft.chinookjpa.model */

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@Entity
@Table(name = "media_types")
public class MediaTypes  extends BaseId<Long> {
    @Id
    @Column(name = "media_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch= FetchType.LAZY, cascade= CascadeType.ALL, mappedBy="mediaTypes")
    @JsonIgnore
    private Set<Tracks> tracks;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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
