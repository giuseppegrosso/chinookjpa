package it.plansoft.chinookjpa.controller;/* ggrosso created on 05/03/2021 inside the package - it.plansoft.chinook.controller */

import it.plansoft.chinookjpa.controller.interfaces.ICrudController;
import it.plansoft.chinookjpa.model.BaseId;
import it.plansoft.chinookjpa.service.BaseCrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class BaseCrudController<
        SERVICE extends BaseCrudService<REPOSITORY, MODEL, ID>,
        REPOSITORY extends JpaRepository<MODEL, ID>,
        MODEL extends BaseId<ID>,
        ID>
        implements ICrudController<MODEL, ID> {

    protected SERVICE service;

    public BaseCrudController(SERVICE service) {
        this.service = service;
    }

    // ?page=0&size=2&sort=createdAt,desc
    @GetMapping("/paged")
    public ResponseEntity<Page<MODEL>> findAll(Pageable pageable) {
        Page<MODEL> page = service.findAll(pageable);
        return ResponseEntity.ok(page);
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<List<MODEL>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Optional<MODEL>> findById(@PathVariable ID id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<MODEL> save(@RequestBody MODEL model) {
        return ResponseEntity.ok(service.save(model));
    }

    @Override
    @PostMapping("/addAll")
    public ResponseEntity<List<MODEL>> saveAll(@RequestBody List<MODEL> model) {
        return ResponseEntity.ok(service.saveAll(model));
    }

    @Override
    @DeleteMapping("/")
    public ResponseEntity<Optional<MODEL>> delete(MODEL model) {
        Optional<MODEL> m = service.findById(model.getId());

        if (m != null && m.get() != null)
            service.delete(model);

        return ResponseEntity.ok(m);
    }

    @Override
    @PostMapping("/{id}")
    public ResponseEntity<Optional<MODEL>> deleteById(@PathVariable ID id) {
        Optional<MODEL> m = service.findById(id);

        if (m != null && m.get() != null)
            service.deleteById(id);

        return ResponseEntity.ok(m);
    }

    @Override
    @PutMapping("/")
    public ResponseEntity<MODEL> update(@RequestBody MODEL model) {
        return ResponseEntity.ok(service.save(model));
    }
}