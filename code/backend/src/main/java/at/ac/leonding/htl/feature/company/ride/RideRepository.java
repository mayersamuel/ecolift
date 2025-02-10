package at.ac.leonding.htl.feature.company.ride;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class RideRepository implements PanacheRepository<Ride> {
    public List<Ride> listAllInCompany(Long companyId) {
        if (companyId == null) {
            throw new IllegalArgumentException("No company id provided!");
        }

        return find("host.company.id", companyId).list();
    }

    public Ride findByIdInCompany(Long rideId, Long companyId) {
        if (rideId == null || companyId == null) {
            throw new IllegalArgumentException("No ride id or company id provided!");
        }

        return find("id = ?1 and host.company.id = ?2", rideId, companyId).firstResult();
    }
}
