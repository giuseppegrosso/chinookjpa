package it.plansoft.chinookjpa.service;/* ggrosso created on 21/02/2021 inside the package - it.plansoft.demojpa.service */

import it.plansoft.chinookjpa.service.interfaces.ICrudService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
public class BaseCrudService<REPOSITORY extends JpaRepository<MODEL, ID>, MODEL, ID> implements ICrudService<MODEL, ID> {

    protected REPOSITORY repository;

    public BaseCrudService(REPOSITORY repository) {
        this.repository = repository;
    }

    @Override
    public List<MODEL> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<MODEL> findAll(Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public Optional<MODEL> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public MODEL save(MODEL model) {
        return repository.save(model);
    }

    @Override
    public List<MODEL> saveAll(List<MODEL> model) {
        List<MODEL> mout = new ArrayList<>();
        for (MODEL m : model) {
            mout.add(m);
            repository.save(m);
        }
        return mout;
    }

    @Override
    public void delete(MODEL model) {
        repository.delete(model);
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    @Override
    public MODEL update(MODEL model) {
        return repository.save(model);
    }
}
