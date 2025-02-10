package at.ac.leonding.htl.feature.company.ride;

import at.ac.leonding.htl.feature.company.person.Person;
import jakarta.persistence.*;

@Entity
public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne
    @JoinColumn(name = "host_id")
    public Person host;

    public String startDestination;

    public String targetDestination;

    public Ride() {
    }
}
