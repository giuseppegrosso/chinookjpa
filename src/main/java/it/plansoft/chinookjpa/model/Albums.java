package it.plansoft.chinookjpa.model;/* ggrosso created on 27/02/2021 inside the package - it.plansoft.chinookjpa.model */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "Albums")
@Table(name = "albums", uniqueConstraints = {@UniqueConstraint(name = "albums_title_unique", columnNames = "title")})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Albums extends BaseId<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_id")
    private Long id;


    @Column(name = "title")
    private String title;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "artist_id")
    private Artists artist;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "album")
    @JsonManagedReference
    private Set<Tracks> tracks;


    public Albums(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}
