package it.plansoft.chinookjpa.service;/* ggrosso created on 02/03/2021 inside the package - it.plansoft.chinookjpa.service */

import it.plansoft.chinookjpa.model.Albums;
import it.plansoft.chinookjpa.model.Artists;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class AlbumArtistService {

    private AlbumService albumService;
    private ArtistService artistService;

    @Autowired
    public AlbumArtistService(AlbumService albumService, ArtistService artistService) {
        this.albumService = albumService;
        this.artistService = artistService;
    }

    @Transactional
    public Albums insertAlbumAndArtist(Albums albums) {
        if (albums != null) {
            if (albums.getArtist() != null) {
                Artists a = albums.getArtist();
                // lettura dell'artista se non esiste lo inserisco
                artistService.findByName(a.getName()).map(item -> {
                    return null;
                }).orElseGet(() -> {
                    return artistService.save(a);
                });

            }

            if (true) throw new RuntimeException("Errore Finto");
            albumService.save(albums);

        }
        return albums;

    }

}
