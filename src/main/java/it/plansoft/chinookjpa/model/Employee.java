package it.plansoft.chinookjpa.model;/* ggrosso created on 05/03/2021 inside the package - it.plansoft.chinookjpa.model */

import lombok.Data;

import javax.persistence.*;


@Entity(name = "Employees")
@Table(name = "employees")
@Data
public class Employee extends BaseId<Long>{
    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Override
    public Long getId() {
        return id;
    }
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "title")
    private String title;

}
