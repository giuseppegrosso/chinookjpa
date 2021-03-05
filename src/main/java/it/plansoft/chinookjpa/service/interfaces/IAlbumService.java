package it.plansoft.chinookjpa.service.interfaces;/* ggrosso created on 21/02/2021 inside the package - it.plansoft.demojpa.service.interfaces */

import it.plansoft.chinookjpa.model.Artists;

import java.util.Set;

public interface IAlbumService<Albums> {
    Set<Albums> findByArtist(Artists artist);
    Set<Albums> findByArtistName(String name);

    Set<Albums> findByArtistId(Long id);
}
