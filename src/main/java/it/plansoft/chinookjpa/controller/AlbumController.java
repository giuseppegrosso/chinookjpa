package it.plansoft.chinookjpa.controller;/* ggrosso created on 05/03/2021 inside the package - it.plansoft.chinook.controller */

import it.plansoft.chinookjpa.controller.interfaces.IAlbumController;
import it.plansoft.chinookjpa.model.Albums;
import it.plansoft.chinookjpa.model.Artists;
import it.plansoft.chinookjpa.repository.AlbumRepository;
import it.plansoft.chinookjpa.service.AlbumArtistService;
import it.plansoft.chinookjpa.service.AlbumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/album")
public class AlbumController extends BaseCrudController<AlbumService, AlbumRepository, Albums, Long> implements IAlbumController<Albums> {

    private AlbumArtistService albumArtistService;

    public AlbumController(AlbumService service, AlbumArtistService albumArtistService) {
        super(service);
        this.albumArtistService = albumArtistService;
    }

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


    @Override
    @GetMapping("/trackName/{name}")
    public ResponseEntity<Set<Albums>> findByTrackName(@PathVariable String name) {
        return ResponseEntity.ok(service.findByTrackName(name));
    }

    @Override
    @PostMapping("/insertTransaction")
    public ResponseEntity<Albums> save(@RequestBody Albums model) {
        return ResponseEntity.ok(albumArtistService.insertAlbumAndArtist(model));
    }



}
