package it.plansoft.chinookjpa.interfaces;/* ggrosso created on 06/03/2021 inside the package - it.plansoft.chinookjpa.interfaces */

import it.plansoft.chinookjpa.model.BaseId;
import it.plansoft.chinookjpa.service.BaseCrudService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public abstract class BaseCrudRepositoryTest<
        SERVICE extends BaseCrudService<REPOSITORY, MODEL, ID>,
        REPOSITORY extends JpaRepository<MODEL, ID>,
        MODEL extends BaseId<ID>, ID> {

    protected SERVICE service;
    protected REPOSITORY repository;
    protected MODEL model;

    protected abstract List<MODEL> getInsertElement();

    public void setRepository(SERVICE service, REPOSITORY repository, MODEL model) {
        this.service = service;
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


    public void insertRepo() {
        this.repository.saveAll(getInsertElement());
    }


    public Optional<MODEL> getRepoById(ID id) {
        Optional<MODEL> rlist = repository.findById(id);
        assertNotNull(rlist);

        return rlist;
    }

    public void deleteRepo(MODEL model) {
        List<MODEL> rlist = repository.findAll();
        assertTrue(rlist.size() > 0);

        repository.delete(model);

        List<MODEL> rlist2 = repository.findAll();
        assertTrue(rlist.size() > 0);

        assertEquals(rlist.size() - 1, rlist2.size());

    }

    public void deleteRepoById(ID id) {
        List<MODEL> rlist = repository.findAll();
        assertTrue(rlist.size() > 0);

        repository.deleteById(id);

        List<MODEL> rlist2 = repository.findAll();
        assertTrue(rlist.size() > 0);

        assertEquals(rlist.size() - 1, rlist2.size());

    }


    /********************************************************************************
     * TEST SERVICE
     *********************************************************************************/

    public void getServiceById(ID id) {
        Optional<MODEL> r = service.findById(id);
        assertNotNull(r);
        assertNotNull(r.get());

        // check di lettura id
        assertEquals(r.get().getId(), id);
    }

    public  List<MODEL> getServiceAll() {

        List<MODEL> rlist = service.findAll();

        assertTrue(rlist.size() > 0);

        return rlist;
    }

    public void getServiceinsert() {

        List<MODEL> mm = getInsertElement();

        List<MODEL> mi = service.saveAll(mm);

        List<MODEL> mi2 = service.findAll();

        assertEquals(mi.size(), mi2.size());


        for (MODEL m : mi2) {
            Optional<MODEL> e = service.findById(m.getId());

            assertNotNull(e);
            assertNotNull(e.get());
            // check di lettura id
            assertEquals(e.get().getId(), m.getId());
        }
    }

    public void deleteService(MODEL model) {
        deleteServiceById(model.getId());
    }

    public void deleteServiceById(ID id) {
        List<MODEL> rlist = service.findAll();

        assertTrue(rlist.size() > 0);

        service.deleteById(id);

        List<MODEL> rlist2 = service.findAll();

        assertTrue(rlist2.size() > 0);
        assertEquals(rlist.size() - 1, rlist2.size());
    }

}
