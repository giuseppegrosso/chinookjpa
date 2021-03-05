package it.plansoft.chinookjpa.service;/* ggrosso created on 05/03/2021 inside the package - it.plansoft.chinook.service */

import it.plansoft.chinookjpa.repository.INameRepository;
import it.plansoft.chinookjpa.service.interfaces.INameInterface;

import java.util.Optional;

/**
 * implemetazone di base per il get by Name
 *
 * @param <MODEL>
 */
public class BaseNameService<
        REPOSITORY extends INameRepository<MODEL, ID>,
        MODEL,
        ID> extends BaseCrudService<REPOSITORY, MODEL, ID> implements INameInterface<MODEL> {

    public BaseNameService(REPOSITORY repository) {
        super(repository);
    }

    public Optional<MODEL> findByName(String name) {
        return repository.findByName(name);
    }
}
