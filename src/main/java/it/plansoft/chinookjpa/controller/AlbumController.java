package it.plansoft.chinookjpa.controller;/* ggrosso created on 05/03/2021 inside the package - it.plansoft.chinook.controller */

import it.plansoft.chinookjpa.controller.interfaces.IAlbumController;
import it.plansoft.chinookjpa.model.Albums;
import it.plansoft.chinookjpa.model.Artists;
import it.plansoft.chinookjpa.repository.AlbumRepository;
import it.plansoft.chinookjpa.service.AlbumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/album")
public class AlbumController extends BaseCrudController<AlbumService, AlbumRepository, Albums, Long> implements IAlbumController<Albums> {

    public AlbumController(AlbumService service) {
        super(service);
    }

//    @Override
//    @GetMapping("/findAllDto")
//    public ResponseEntity<List<MODEL>> findAll() {
//        return ResponseEntity.ok(service.findAll());
//    }


    @GetMapping("/artistName/{name}")
    public ResponseEntity<Set<Albums>> findByArtistName(@PathVariable String name) {
        return ResponseEntity.ok(service.findByArtistName(name));
    }

    @GetMapping("/artistId/{id}")
    public ResponseEntity<Set<Albums>> findByArtist(@PathVariable Long id) {
        return ResponseEntity.ok(service.findByArtistId(id));
    }

    @Override
    public ResponseEntity<Set<Albums>> findByArtist(Artists artist) {
        return ResponseEntity.ok(service.findByArtist(artist));
    }

}
