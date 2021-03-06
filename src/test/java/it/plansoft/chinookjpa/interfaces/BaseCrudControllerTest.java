package it.plansoft.chinookjpa.interfaces;

import it.plansoft.chinookjpa.controller.interfaces.ICrudController;
import it.plansoft.chinookjpa.model.BaseId;
import it.plansoft.chinookjpa.service.interfaces.ICrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public abstract class BaseCrudControllerTest<
        CONTROLLER extends ICrudController<MODEL, ID>,
        SERVICE extends ICrudService<MODEL, ID>,
        REPOSITORY extends JpaRepository<MODEL, ID>,
        MODEL extends BaseId<ID>, ID>
        //implements ICrudController<MODEL, ID>
{

    protected CONTROLLER controller;
    protected SERVICE service;
    protected REPOSITORY repository;
    protected MODEL model;

    public BaseCrudControllerTest() {
    }

    public BaseCrudControllerTest(CONTROLLER controller,
                                  SERVICE service,
                                  REPOSITORY repository,
                                  MODEL model) {
        this.controller = controller;
        this.service = service;
        this.repository = repository;
        this.model = model;
    }

    // abstract method
    protected abstract MODEL getInsertElement();

    /**
     * TEST SUI CONTROLLER
     *
     * @return
     */

    public ResponseEntity<List<MODEL>> findAll() {
        ResponseEntity<List<MODEL>> rlist = controller.findAll();

        assertTrue(rlist.getBody().size() > 0);

        return rlist;
    }

    public ResponseEntity<Page<MODEL>> findAll(Pageable pageable) {
        ResponseEntity<Page<MODEL>> rlist = controller.findAll(pageable);

        assertNotNull(rlist.getBody());

        return rlist;
    }

    public ResponseEntity<Optional<MODEL>> findById(ID id) {
        ResponseEntity<Optional<MODEL>> r = controller.findById(id);

        assertNotNull(r);
        return r;
    }


    public void deleteById(ID id) {
        controller.deleteById(id);
    }

    public void delete(MODEL model) {
        controller.delete(model);
    }

    public ResponseEntity<MODEL> save(MODEL albums) {
        return controller.save(model);
    }

    public ResponseEntity<List<MODEL>> saveAll(List<MODEL> model) {
        return controller.saveAll(model);
    }

    public ResponseEntity<MODEL> update(MODEL albums) {
        return controller.update(model);
    }




    /********************************************************************************
     * TEST SERVICE
     *********************************************************************************/

    public void getServiceById() throws Exception {
        List<MODEL> rlist = service.findAll();
        assertTrue(rlist.size() > 0);

        MODEL r = rlist.get(0);

        // get Data ById
        Optional<MODEL> e = service.findById(r.getId());

        assertNotNull(e);
        assertNotNull(e.get());

        // check di lettura id
        assertEquals(e.get().getId(), r.getId());
    }

    public void getServiceAll() throws Exception {

        List<MODEL> rlist = service.findAll();

        assertTrue(rlist.size() > 0);
    }

    public void insert() throws Exception {

        MODEL m = getInsertElement();

        MODEL mi = (MODEL) service.save(m);
        Optional<MODEL> e = service.findById(mi.getId());


        assertNotNull(e);
        assertNotNull(e.get());

        // check di lettura id
        assertEquals(e.get().getId(), mi.getId());
    }

    /********************************************************************************
     * TEST REPOSITORY
     *********************************************************************************/
    public void insertRepo()
    {
        this.repository.save(getInsertElement());
    }


    public void getRepoById(ID id) throws Exception {
        Optional<MODEL> rlist = repository.findById(id);
        assertNotNull(rlist);
    }

    public void getRepoAll()  {
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

    public void deleteRepo(MODEL model)  {
        List<MODEL> rlist = repository.findAll();
        assertTrue(rlist.size() > 0);

        repository.delete(model);

        List<MODEL> rlist2 = repository.findAll();
        assertTrue(rlist.size() > 0);

        assertEquals(rlist.size() - 1, rlist2.size());

    }

    public void deleteRepoById(ID id)  {
        List<MODEL> rlist = repository.findAll();
        assertTrue(rlist.size() > 0);

        repository.deleteById(id);

        List<MODEL> rlist2 = repository.findAll();
        assertTrue(rlist.size() > 0);

        assertEquals(rlist.size() - 1, rlist2.size());

    }


}
