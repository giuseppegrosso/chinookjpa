package it.plansoft.chinookjpa.controller;/* ggrosso created on 28/02/2021 inside the package - it.plansoft.chinookjpa.controller */

import it.plansoft.chinookjpa.model.*;
import it.plansoft.chinookjpa.repository.PlaylistRepository;
import it.plansoft.chinookjpa.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/playlist")
public class PlaylistController extends BaseCrudController<PlaylistService, PlaylistRepository, Playlist, Long> {


    private TrackService trackService;
    private AlbumService albumService;
    private ArtistService artistService;
    private MediaTypeService mediaTypeService;
    private GenreService genreService;


    public PlaylistController(PlaylistService service, TrackService trackService, AlbumService albumService, ArtistService artistService, MediaTypeService mediaTypeService, GenreService genreService) {
        super(service);
        this.trackService = trackService;
        this.albumService = albumService;
        this.artistService = artistService;
        this.mediaTypeService = mediaTypeService;
        this.genreService = genreService;
    }

    @Override
    @PostMapping("/addAll")
    public ResponseEntity<List<Playlist>> saveAll(@RequestBody List<Playlist> model) {
        recursiveAdd(model);
        return ResponseEntity.ok(model);
    }

    private void recursiveAdd(List<Playlist> playlists) {
        for (Playlist p : playlists) {
            if (p != null) {
                Set<Tracks> t = p.getTracks();
                recursiveAdd(t);
            }
            service.save(p);
        }
    }

    private void recursiveAdd(Set<Tracks> tracks) {
        for (Tracks t : tracks) {
            if (t != null) {
                recursiveAdd(t.getAlbum());
                addItem(t.getMediaTypes(), mediaTypeService);
                addItem(t.getGenres(), genreService);

                addItem(t, trackService);
            }
        }
    }

    private void recursiveAdd(Albums album) {
        if (album != null) {
            recursiveAdd(album.getArtist());
            // verifico se esiste
            addItem(album, albumService);
        }
    }

    private void recursiveAdd(Artists artists) {
        if (artists != null) {
            // verifico se esiste
            addItem(artists, artistService);
        }
    }

    /**
     * generalizzazione inserimento elemento in bsae dati
     *
     * @param mClazz
     * @param sClazz
     * @param <M>
     * @param <S>
     * @return
     */
    private <M extends BaseId, S extends BaseCrudService> M addItem(M mClazz, S sClazz) {
        // verifico se esiste
        sClazz.findById(mClazz.getId()).map(item -> {
            //System.out.println("item già esistente");
            return null;
        }).orElseGet(() -> {
            return sClazz.save(mClazz);
        });
        return null;
    }

}
