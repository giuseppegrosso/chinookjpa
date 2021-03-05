package it.plansoft.chinookjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface INameRepository<MODEL, ID> extends JpaRepository<MODEL, ID> {
    Optional<MODEL> findByName(String name);
}
