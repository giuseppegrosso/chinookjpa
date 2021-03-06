package it.plansoft.chinookjpa.model;/* ggrosso created on 05/03/2021 inside the package - it.plansoft.chinookjpa.model */

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity(name = "Customers")
@Table(name = "customers")
@Data
public class Customer extends BaseId<Long>{
    @Id
    @Column(name = "customers_id")
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

    @Column(name = "company")
    private String company;

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

    @ManyToOne
    @JoinColumn( name="support_rep_id" )
    private Employee employee;






}
