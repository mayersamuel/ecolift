package at.ac.leonding.htl.feature.company.person;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {
    public List<Person> listAllInCompany(Long companyId) {
        if (companyId == null) {
            throw new IllegalArgumentException("No company id provided!");
        }

        return find("company.id = ?1", companyId).list();
    }

    public Person findByIdInCompany(Long personId, Long companyId) {
        if (personId == null || companyId == null) {
            throw new IllegalArgumentException("No person id or company id provided!");
        }

        return find("id = ?1 and company.id = ?2", personId, companyId).firstResult();
    }
}
