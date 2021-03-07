package it.plansoft.chinookjpa;

import it.plansoft.chinookjpa.interfaces.BaseCrudRepositoryTest;
import it.plansoft.chinookjpa.model.Albums;
import it.plansoft.chinookjpa.repository.AlbumRepository;
import it.plansoft.chinookjpa.service.AlbumService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class AlbumsTest extends BaseCrudRepositoryTest<
        AlbumService,
        AlbumRepository,
        Albums, Long> {

    @Autowired
    private AlbumService service;
    @Autowired
    private AlbumRepository repository;

    @Test
    public void testRepository() {
        setRepository(service, repository, new Albums());
        insertRepo();
        findAll();
        Optional<Albums> a = getRepoById(2L);
        deleteRepo(a.get());

        deleteRepoById(1L);
        findAll();

    }


    @Test
    public void testService() {
        setRepository(service, repository, new Albums());
        getServiceinsert();
        getServiceAll();
        getServiceById(2L);
        deleteService(new Albums(2L, "", null));

        deleteServiceById(1L);
        getServiceAll();
    }


    @Override
    protected List<Albums> getInsertElement() {
        return Arrays.asList(
                new Albums(1L, "prova di album",
                null
        ),
                new Albums(2L, "prova di album 2",
                        null
                ),
                new Albums(3L, "prova di album 3",
                        null
                ));
    }


}