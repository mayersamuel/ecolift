package at.ac.leonding.htl.ride;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String starDestination;

    String targetDestination;

    public Ride() {
    }
}
