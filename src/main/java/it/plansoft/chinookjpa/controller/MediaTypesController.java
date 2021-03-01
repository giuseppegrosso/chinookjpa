package it.plansoft.chinookjpa.controller;/* ggrosso created on 28/02/2021 inside the package - it.plansoft.chinookjpa.controller.interfaces */

import it.plansoft.chinookjpa.model.MediaTypes;
import it.plansoft.chinookjpa.repository.MediaTypeRepository;
import it.plansoft.chinookjpa.service.MediaTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/media")
public class MediaTypesController extends BaseCrudController<MediaTypeService, MediaTypeRepository, MediaTypes, Long> {


    public MediaTypesController(MediaTypeService service) {
        super(service);
    }
}
