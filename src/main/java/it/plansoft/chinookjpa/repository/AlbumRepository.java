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
    Set<Albums> findByTracksName(String trackName);

    // inferred
    Set<Albums> findByTitle(String title);
    //JPQL
    @Query("select a from Albums a where a.title = :title")
    Set<Albums> findByTitleCustomQuery(@Param("title") String title);
    //NATIVO
    @Query("select a from Albums a where a.title = :title")
    Set<Albums> findByTitleNativeQuery(@Param("title") String title);


//    // INFERRED
//    Set<Albums> findByArtistName(String artistName);
//    //JPQL
//    @Query("select a from Albums a JOIN Artists artist where artist.name = :name")
//    Set<Albums> findByArtistNameCustomQuery(@Param("name") String name);
//    // NATIVA
//    @Query(
//            value = "select *, TO_STRING(data, 'yyyy-MM-dd HH24:mi:ss') from albums as a Left join artists artist where artist.name = :name",
//            nativeQuery = true)
//    Set<Albums> findByArtistNameNativeQuery(@Param("name") String name);

}
