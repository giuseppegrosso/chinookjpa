package it.plansoft.chinookjpa.repository;/* ggrosso created on 27/02/2021 inside the package - it.plansoft.chinookjpa.repository */

import it.plansoft.chinookjpa.model.Albums;
import it.plansoft.chinookjpa.model.Artists;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * repository classe album
 */
@Repository
public interface AlbumRepository extends JpaRepository<Albums, Long> {

    Set<Albums> findByArtist(Artists artist);
    Set<Albums> findByArtistId(Long idArtist);
}
