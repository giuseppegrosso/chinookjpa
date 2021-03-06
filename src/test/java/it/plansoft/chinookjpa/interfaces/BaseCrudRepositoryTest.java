package it.plansoft.chinookjpa.interfaces;/* ggrosso created on 06/03/2021 inside the package - it.plansoft.chinookjpa.interfaces */

import it.plansoft.chinookjpa.model.BaseId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public abstract class BaseCrudRepositoryTest<REPOSITORY extends JpaRepository<MODEL, ID>, MODEL extends BaseId<ID>, ID> {

    protected REPOSITORY repository;
    protected MODEL model;

    protected abstract MODEL getInsertElement();

    public BaseCrudRepositoryTest(REPOSITORY repository, MODEL model) {
        this.repository = repository;
        this.model = model;
    }

    public void findAll() {
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
