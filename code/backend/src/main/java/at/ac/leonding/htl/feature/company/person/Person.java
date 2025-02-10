package at.ac.leonding.htl.feature.company.person;

import at.ac.leonding.htl.feature.company.Company;
import at.ac.leonding.htl.feature.company.ride.Ride;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    public Company company;

    public String name;

    @ManyToMany
    public List<Ride> rides;

    public Person() {
    }
}
