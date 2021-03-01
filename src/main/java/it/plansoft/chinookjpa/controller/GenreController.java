package it.plansoft.chinookjpa.controller;/* ggrosso created on 28/02/2021 inside the package - it.plansoft.chinookjpa.controller.interfaces */

import it.plansoft.chinookjpa.model.Genres;
import it.plansoft.chinookjpa.repository.GenreRepository;
import it.plansoft.chinookjpa.service.GenreService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/genre")
public class GenreController extends BaseCrudController<GenreService, GenreRepository, Genres, Long> {


    public GenreController(GenreService service) {
        super(service);
    }
}
