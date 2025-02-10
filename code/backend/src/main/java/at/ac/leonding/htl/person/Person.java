package at.ac.leonding.htl.person;

import at.ac.leonding.htl.ride.Ride;
import at.ac.leonding.htl.feature.company.Company;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    Company company;

    String name;

    @ManyToMany
    List<Ride> rides;

    public Person() {
    }
}
