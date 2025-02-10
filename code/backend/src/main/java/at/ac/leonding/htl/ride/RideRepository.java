package at.ac.leonding.htl.ride;

import at.ac.leonding.htl.feature.company.Company;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RideRepository implements PanacheRepository<Ride> {
}
