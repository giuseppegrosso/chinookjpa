package it.plansoft.chinookjpa.repository;

import it.plansoft.chinookjpa.model.Tracks;
import org.springframework.stereotype.Repository;

import javax.sound.midi.Track;

@Repository
public interface TrackRepository extends INameRepository<Tracks, Long> {
}
