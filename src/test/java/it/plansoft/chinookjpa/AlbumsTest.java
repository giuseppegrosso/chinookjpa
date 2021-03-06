package it.plansoft.chinookjpa;

import it.plansoft.chinookjpa.interfaces.BaseCrudRepositoryTest;
import it.plansoft.chinookjpa.model.Albums;
import it.plansoft.chinookjpa.repository.AlbumRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public class AlbumsTest extends BaseCrudRepositoryTest<
        AlbumRepository,
        Albums, Long> {


    public AlbumsTest(
            AlbumRepository repo,
            Albums model) {
        super(repo, model);
    }


    @Override
    protected Albums getInsertElement() {
        return new Albums(1L, "prova di album",
                null
        );
    }


}