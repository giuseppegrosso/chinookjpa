package it.plansoft.chinookjpa.controller.interfaces;/* ggrosso created on 21/02/2021 inside the package - it.plansoft.demojpa.controller.interfaces */

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface ICrudController<MODEL, ID> {

    ResponseEntity<List<MODEL>> findAll();

    ResponseEntity<Page<MODEL>> findAll(Pageable pageable);

    ResponseEntity<Optional<MODEL>> findById(ID id);

    ResponseEntity<MODEL> save(MODEL model);

    ResponseEntity<List<MODEL>> saveAll(List<MODEL> model);

    void delete(MODEL model);

    void deleteById(ID id);

    ResponseEntity<MODEL> update(MODEL model);


}
