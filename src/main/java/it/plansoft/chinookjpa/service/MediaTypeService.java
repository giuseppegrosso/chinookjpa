package it.plansoft.chinookjpa.service;/* ggrosso created on 01/03/2021 inside the package - it.plansoft.chinookjpa.service */

import it.plansoft.chinookjpa.model.MediaTypes;
import it.plansoft.chinookjpa.repository.MediaTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class MediaTypeService extends BaseCrudService<MediaTypeRepository, MediaTypes, Long> {

    public MediaTypeService(MediaTypeRepository mediaTypeRepository) {
        super(mediaTypeRepository);
    }


}
