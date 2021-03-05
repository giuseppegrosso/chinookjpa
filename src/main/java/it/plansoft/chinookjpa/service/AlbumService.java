package it.plansoft.chinookjpa.service;/* ggrosso created on 27/02/2021 inside the package - it.plansoft.chinookjpa.service */

import it.plansoft.chinookjpa.model.Albums;
import it.plansoft.chinookjpa.model.Artists;
import it.plansoft.chinookjpa.repository.AlbumRepository;
import it.plansoft.chinookjpa.service.interfaces.IAlbumService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AlbumService extends BaseCrudService<AlbumRepository, Albums, Long> implements IAlbumService<Albums> {

    public AlbumService(AlbumRepository repository) {
        super(repository);
    }

    @Override
    public Set<Albums> findByArtist(Artists artist) {
        return repository.findByArtist(artist);
    }

    @Override
    public Set<Albums> findByArtistId(Long id) {
        return repository.findByArtistId(id);
    }
    @Override
    public Set<Albums> findByArtistName(String name) {
        return repository.findByArtistName(name);
    }

}