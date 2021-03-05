package it.plansoft.chinookjpa.service;/* ggrosso created on 27/02/2021 inside the package - it.plansoft.chinookjpa.service */

import it.plansoft.chinookjpa.model.Artists;
import it.plansoft.chinookjpa.repository.ArtistsRepository;
import it.plansoft.chinookjpa.service.interfaces.IArtistService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArtistService extends BaseCrudService<ArtistsRepository, Artists, Long> implements IArtistService<Artists> {


    public ArtistService(ArtistsRepository artistRepository) {
        super(artistRepository);
    }

    @Override
    public Optional<Artists> findByName(String name) {
        return repository.findByName(name);
    }
}