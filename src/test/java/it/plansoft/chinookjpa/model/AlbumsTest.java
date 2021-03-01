package it.plansoft.chinookjpa.model;

import it.plansoft.chinookjpa.repository.AlbumRepository;
import it.plansoft.chinookjpa.repository.ArtistsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class AlbumsTest {

    private AlbumRepository albumRepository;
    private ArtistsRepository artistsRepository;

    @Autowired
    public AlbumsTest(AlbumRepository albumRepository, ArtistsRepository artistsRepository) {
        this.albumRepository = albumRepository;
        this.artistsRepository = artistsRepository;
    }

    @Test
    public void insertAlbum()
    {
        this.albumRepository.save(
                new Albums(1L, "prova di album",
                        new Artists(1L, "artista di prova")
                ));
    }
}