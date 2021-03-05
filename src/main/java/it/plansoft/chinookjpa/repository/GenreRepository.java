package it.plansoft.chinookjpa.repository;/* ggrosso created on 05/03/2021 inside the package - it.plansoft.chinook.repository */

import it.plansoft.chinookjpa.model.Genres;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends INameRepository<Genres, Long> {
}
