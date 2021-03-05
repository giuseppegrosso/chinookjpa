package it.plansoft.chinookjpa.service;/* ggrosso created on 28/02/2021 inside the package - it.plansoft.chinookjpa.service */

import it.plansoft.chinookjpa.model.Tracks;
import it.plansoft.chinookjpa.repository.TrackRepository;
import it.plansoft.chinookjpa.service.interfaces.INameInterface;
import org.springframework.stereotype.Service;

@Service
public class TrackService extends BaseNameService<TrackRepository, Tracks, Long> implements INameInterface<Tracks> {

    private TrackRepository repository;

    public TrackService(TrackRepository repository) {
        super(repository);
    }
}
