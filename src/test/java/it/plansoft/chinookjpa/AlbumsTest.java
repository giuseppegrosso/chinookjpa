package it.plansoft.chinookjpa;

import it.plansoft.chinookjpa.interfaces.BaseCrudRepositoryTest;
import it.plansoft.chinookjpa.model.Albums;
import it.plansoft.chinookjpa.model.Tracks;
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
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
        List<Albums> list = getServiceAll();
        getServiceById(list.get(0).getId());
        deleteService(list.get(0));

        deleteServiceById(list.get(1).getId());
        getServiceAll();
    }


    @Test
    public void testCustomSQL() {
        setRepository(service, repository, new Albums());
        Set<Albums> albums = repository.findByTracksName("Inject The Venom");

        assertNotNull(albums);

        albums.forEach(album -> {
            // check di lettura id
            Set<Tracks>tracs = album.getTracks();
            tracs.forEach(track -> {
                assertEquals(track.getName(), "Inject The Venom");
            });

        });


    }



    @Override
    protected List<Albums> getInsertElement() {
        return Arrays.asList(
                new Albums(1L, "prova di album"
                ),
                new Albums(2L, "prova di album 2"
                ),
                new Albums(3L, "prova di album 3"
                ));
    }


}