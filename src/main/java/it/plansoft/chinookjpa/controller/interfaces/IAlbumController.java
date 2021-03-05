package it.plansoft.chinookjpa.controller.interfaces;

import it.plansoft.chinookjpa.model.Albums;
import it.plansoft.chinookjpa.model.Artists;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface IAlbumController<T> {
    ResponseEntity<Set<Albums>> findByArtist(Artists artist);
    ResponseEntity<Set<Albums>> findByArtistName(String name);
}
