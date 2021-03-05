package it.plansoft.chinookjpa.service.interfaces;

import it.plansoft.chinookjpa.model.Artists;

import java.util.Optional;

public interface IArtistService<Artist> {
    Optional<Artists> findByName(String name);
}
