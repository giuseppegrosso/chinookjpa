package it.plansoft.chinookjpa.repository;

import it.plansoft.chinookjpa.model.Playlist;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends INameRepository<Playlist, Long> {
}
