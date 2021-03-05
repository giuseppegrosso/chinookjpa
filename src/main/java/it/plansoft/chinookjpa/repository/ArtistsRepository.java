package it.plansoft.chinookjpa.repository;/* ggrosso created on 27/02/2021 inside the package - it.plansoft.chinookjpa.repository */

import it.plansoft.chinookjpa.model.Albums;
import it.plansoft.chinookjpa.model.Artists;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArtistsRepository extends JpaRepository<Artists, Long> {

    Optional<Artists> findByName(String name);


//    @Query("SELECT s FROM artists a WHERE a.name = ?1")
//    Optional<Artists> findByNameQuery(String name);
//
//
//    @Transactional
//    @Modifying
//    @Query("DELETE FROM artists a WHERE u.artist_id = ?1")
//    int deleteArtistsById(Long id);
}

