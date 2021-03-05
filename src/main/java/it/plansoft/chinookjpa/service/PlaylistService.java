package it.plansoft.chinookjpa.service;/* ggrosso created on 28/02/2021 inside the package - it.plansoft.chinookjpa.service */

import it.plansoft.chinookjpa.model.Playlist;
import it.plansoft.chinookjpa.repository.PlaylistRepository;
import it.plansoft.chinookjpa.service.interfaces.INameInterface;
import org.springframework.stereotype.Service;

@Service
public class PlaylistService extends BaseNameService<PlaylistRepository, Playlist, Long> implements INameInterface<Playlist> {

    public PlaylistService(PlaylistRepository playlistRepository) {
        super(playlistRepository);
    }

}
