package it.plansoft.chinookjpa.repository;/* ggrosso created on 27/02/2021 inside the package - it.plansoft.chinookjpa.repository */

import it.plansoft.chinookjpa.model.Albums;
import it.plansoft.chinookjpa.model.Artists;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * repository classe album
 */
@Repository
public interface AlbumRepository extends JpaRepository<Albums, Long> {

    Set<Albums> findByArtistId(Long idArtist);

    Set<Albums> findByArtist(Artists artist);
    Set<Albums> findByArtistName(String artistName);


    Set<Albums> findByTitle(String title);

    @Query("select a from Albums a where a.title = :title")
    Set<Albums> findByTitleCustomQuery(@Param("title") String title);

    @Query(
            value = "select * from albums as a where a.title = :title",
            nativeQuery = true)
    Set<Albums> findByTitleNativeQuery(@Param("title") String title);

}
