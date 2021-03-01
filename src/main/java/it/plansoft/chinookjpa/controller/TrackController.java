package it.plansoft.chinookjpa.controller;/* ggrosso created on 28/02/2021 inside the package - it.plansoft.chinookjpa.controller.interfaces */

import it.plansoft.chinookjpa.model.Tracks;
import it.plansoft.chinookjpa.repository.TrackRepository;
import it.plansoft.chinookjpa.service.TrackService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/track")
public class TrackController extends BaseCrudController<TrackService, TrackRepository, Tracks, Long> {


    public TrackController(TrackService service) {
        super(service);
    }
}
