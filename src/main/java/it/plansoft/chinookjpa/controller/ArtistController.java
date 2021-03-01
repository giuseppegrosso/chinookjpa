package it.plansoft.chinookjpa.controller;/* ggrosso created on 27/02/2021 inside the package - it.plansoft.chinookjpa.controller */

import it.plansoft.chinookjpa.model.Artists;
import it.plansoft.chinookjpa.repository.ArtistsRepository;
import it.plansoft.chinookjpa.service.ArtistService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artist")
public class ArtistController extends BaseCrudController<ArtistService, ArtistsRepository, Artists, Long> {


    public ArtistController(ArtistService service) {
        super(service);
    }


}
