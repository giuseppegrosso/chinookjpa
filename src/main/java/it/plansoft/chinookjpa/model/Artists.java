package it.plansoft.chinookjpa.model;/* ggrosso created on 27/02/2021 inside the package - it.plansoft.chinookjpa.model */

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor

@ToString
@Entity(name = "artists")
@Table(name = "artists")
@Builder
@NoArgsConstructor
public class Artists extends BaseId<Long> {
    @Id
    @Column(name = "artist_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "Name")
    private String name;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artist")
    @JsonIgnore
    private Set<Albums> albums;


    public Artists(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
