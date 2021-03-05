package it.plansoft.chinookjpa.service.interfaces;

import java.util.Optional;

/**
 * interfaccia per il collection by name
 * @param <MODEL>
 */
public interface INameInterface<MODEL> {
    Optional<MODEL> findByName(String name);
}
