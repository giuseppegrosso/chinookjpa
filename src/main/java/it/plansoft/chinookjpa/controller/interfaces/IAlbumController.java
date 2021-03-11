package it.plansoft.chinookjpa.controller.interfaces;

import it.plansoft.chinookjpa.model.Albums;
import it.plansoft.chinookjpa.model.Artists;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

public interface IAlbumController<T> {
    ResponseEntity<Set<Albums>> findByArtist(Artists artist);

    ResponseEntity<Set<Albums>> findByArtistName(String name);

    ResponseEntity<Set<Albums>> findByTrackName(String name);
}
