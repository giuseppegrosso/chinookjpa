package it.plansoft.chinookjpa.controller;/* ggrosso created on 05/03/2021 inside the package - it.plansoft.chinook.controller */

import it.plansoft.chinookjpa.model.Playlist;
import it.plansoft.chinookjpa.repository.PlaylistRepository;
import it.plansoft.chinookjpa.service.PlaylistService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/playlist")
public class PlaylistController extends BaseCrudController<PlaylistService, PlaylistRepository, Playlist, Long> {

    public PlaylistController(PlaylistService service) {
        super(service);
    }

}