package it.plansoft.chinookjpa.service;/* ggrosso created on 01/03/2021 inside the package - it.plansoft.chinookjpa.service */

import it.plansoft.chinookjpa.model.Genres;
import it.plansoft.chinookjpa.repository.GenreRepository;
import org.springframework.stereotype.Service;

@Service
public class GenreService extends BaseNameService<GenreRepository, Genres, Long> {

    public GenreService(GenreRepository genreRepository) {
        super(genreRepository);
    }


}