package it.plansoft.chinookjpa.controller;/* ggrosso created on 05/03/2021 inside the package - it.plansoft.chinook.controller */

import it.plansoft.chinookjpa.dto.PlayListDto;
import it.plansoft.chinookjpa.dto.TracksDto;
import it.plansoft.chinookjpa.model.Playlist;
import it.plansoft.chinookjpa.repository.PlaylistRepository;
import it.plansoft.chinookjpa.service.PlaylistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/playlist")
public class PlaylistController extends BaseCrudController<PlaylistService, PlaylistRepository, Playlist, Long> {

    public PlaylistController(PlaylistService service) {
        super(service);
    }

    @GetMapping("/findAllDto")
    public ResponseEntity<List<PlayListDto>> findAllDto() {
        List<Playlist> all = service.findAll();
        List<PlayListDto> playListDtos = new ArrayList<>();

        all.forEach(x -> {
            Set<TracksDto> tracksDtos = new HashSet<>();
            x.getTracks().forEach(track -> {
                tracksDtos.add(new TracksDto(track.getId(),
                        track.getName(),
                        track.getAlbum(),
                        track.getMediaTypes(),
                        track.getGenres(),
                        track.getInvoiceItems(),
                        track.getComposer(),
                        track.getMilliseconds(),
                        track.getBytes(),
                        track.getUnitPrice() ));
            });

            playListDtos.add(new PlayListDto(x.getId(), x.getName(), tracksDtos));
        });


        return ResponseEntity.ok(playListDtos);
    }

}