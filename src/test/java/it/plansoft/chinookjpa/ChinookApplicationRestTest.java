package it.plansoft.chinookjpa;/* ggrosso created on 06/03/2021 inside the package - it.plansoft.chinookjpa */

import com.fasterxml.jackson.databind.ObjectMapper;
import it.plansoft.chinookjpa.interfaces.BaseCrudRepositoryTest;
import it.plansoft.chinookjpa.model.Albums;
import it.plansoft.chinookjpa.model.Artists;
import it.plansoft.chinookjpa.model.BaseId;
import it.plansoft.chinookjpa.repository.AlbumRepository;
import it.plansoft.chinookjpa.repository.ArtistsRepository;
import org.checkerframework.checker.units.qual.A;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ChinookApplicationRestTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    ArtistsRepository artistsRepository;

    @Before
    public void init() {
        loadDataBase();
    }

    private void loadDataBase()
    {
        albumRepository.save(new Albums(1L, "Giuseppe prova", null));
        artistsRepository.save(new Artists(1L, "Giuseppe prova"));
    }

    @Test
    public void testEndpoint() throws Exception {
        testEndpointUrl("album", "artist", "media", "genre", "track", "playlist", "invoice", "invoiceitem", "employee", "customer");
    }

    protected void testEndpointUrl(String... urls) throws Exception {
        for (String url : urls) {
            this.mvc.perform(get("/" + url + "/")).andDo(print()).andExpect(status().isOk());

            this.mvc.perform(MockMvcRequestBuilders
                    .get("/" + url + "/1")
                    .accept(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk())
            ;

        }

    }

    @Test
    public void testRepository() {
        loadDataBase();
        findAll(albumRepository, Albums.class, Long.class);
        findAll(artistsRepository, Albums.class, Long.class);

    }


    public <MODEL extends BaseId<ID>, ID> void findAll(JpaRepository repository, Class<MODEL> clazz, Class<ID> clazz2) {
        List<MODEL> rlist = repository.findAll();
        assertTrue(rlist.size() > 0);

        MODEL r = rlist.get(0);

        // get Data ById
        Optional<MODEL> e = repository.findById(r.getId());

        assertNotNull(e);
        assertNotNull(e.get());

        // check di lettura id
        assertEquals(e.get().getId(), r.getId());
    }


}
