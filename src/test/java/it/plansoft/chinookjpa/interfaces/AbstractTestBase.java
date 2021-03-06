package it.plansoft.chinookjpa.interfaces;

import it.plansoft.chinookjpa.controller.interfaces.ICrudController;
import it.plansoft.chinookjpa.model.Albums;
import it.plansoft.chinookjpa.model.BaseId;
import it.plansoft.chinookjpa.service.BaseCrudService;
import it.plansoft.chinookjpa.service.interfaces.ICrudService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

/**
 * Test repository
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
public abstract class AbstractTestBase {


    protected abstract void loadDataBase();

    @Before
    public void init() {
        loadDataBase();
    }

    @After
    public void shutdown() {

    }


}