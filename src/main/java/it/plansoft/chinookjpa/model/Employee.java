package it.plansoft.chinookjpa.model;/* ggrosso created on 05/03/2021 inside the package - it.plansoft.chinookjpa.model */

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


@Entity(name = "Employees")
@Table(name = "employees")
@Data
@NoArgsConstructor
public class Employee extends BaseId<Long> {
    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reports_to")
    private Employee manager;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manager")
    @JsonIgnore
    private Set<Employee> subordinates;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supportRep")
    @JsonIgnore
    private Set<Customer> customer;


    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "title")
    private String title;

    @Column(name = "birth_date")
    private String birthDate;

    @Column(name = "hire_date")
    private String hireDate;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "phone")
    private String phone;

    @Column(name = "fax")
    private String fax;

    @Column(name = "email")
    private String email;

}
