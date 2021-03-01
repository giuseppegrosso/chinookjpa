package it.plansoft.chinookjpa.service;/* ggrosso created on 28/02/2021 inside the package - it.plansoft.chinookjpa.service */

import it.plansoft.chinookjpa.model.Tracks;
import it.plansoft.chinookjpa.repository.TrackRepository;
import org.springframework.stereotype.Service;

@Service
public class TrackService extends BaseCrudService<TrackRepository, Tracks, Long> {

    public TrackService(TrackRepository trackRepository) {
        super(trackRepository);
    }

}
