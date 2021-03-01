package it.plansoft.chinookjpa.controller;/* ggrosso created on 27/02/2021 inside the package - it.plansoft.chinookjpa.controller */

import it.plansoft.chinookjpa.model.Albums;
import it.plansoft.chinookjpa.model.Artists;
import it.plansoft.chinookjpa.repository.AlbumRepository;
import it.plansoft.chinookjpa.service.AlbumService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/album")
public class AlbumController extends BaseCrudController<AlbumService, AlbumRepository, Albums, Long> {


    public AlbumController(AlbumService service) {
        super(service);
    }

    @GetMapping("/artist/{id}")
    public ResponseEntity<Set<Albums>> findByArtistId(@PathVariable Long id) {
        Artists artist = new Artists();
        artist.setId(id);
        return ResponseEntity.ok(service.findByArtist(artist));
    }
}
