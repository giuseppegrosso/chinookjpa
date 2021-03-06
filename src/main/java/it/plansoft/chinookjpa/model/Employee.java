package it.plansoft.chinookjpa.model;/* ggrosso created on 05/03/2021 inside the package - it.plansoft.chinookjpa.model */

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;


@Entity(name = "Employees")
@Table(name = "employees")
@Data
public class Employee extends BaseId<Long>{
    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)


//    @ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name="reports_to")
//    private Employee manager;
//
//    @OneToMany(fetch=FetchType.LAZY, cascade= CascadeType.ALL, mappedBy="manager")
//    private Set<Employee> subordinates;




//    @OneToMany(fetch= FetchType.LAZY, cascade= CascadeType.ALL, mappedBy="supportRep")
//    private Set<Customer> customer;

    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "title")
    private String title;

    @Column(name="birth_date")
    private String birthDate;

    @Column(name="hire_date")
    private String hireDate;

    @Column(name="address")
    private String address;

    @Column(name="city")
    private String city;

    @Column(name="state")
    private String state;

    @Column(name="country")
    private String country;

    @Column(name="postal_code")
    private String postalCode;

    @Column(name="phone")
    private String phone;

    @Column(name="fax")
    private String fax;

    @Column(name="email")
    private String email;


    @Override
    public Long getId() {
        return id;
    }

}
