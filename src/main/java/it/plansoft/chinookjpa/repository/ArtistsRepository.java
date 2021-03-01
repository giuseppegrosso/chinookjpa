package it.plansoft.chinookjpa.repository;/* ggrosso created on 27/02/2021 inside the package - it.plansoft.chinookjpa.repository */

import it.plansoft.chinookjpa.model.Albums;
import it.plansoft.chinookjpa.model.Artists;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistsRepository  extends JpaRepository<Artists, Long> {

    Optional<Artists> findByName(String name);
}

