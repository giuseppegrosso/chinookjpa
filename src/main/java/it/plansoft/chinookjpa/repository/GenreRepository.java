package it.plansoft.chinookjpa.repository;/* ggrosso created on 01/03/2021 inside the package - it.plansoft.chinookjpa.repository */

import it.plansoft.chinookjpa.model.Genres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genres, Long> {


}
