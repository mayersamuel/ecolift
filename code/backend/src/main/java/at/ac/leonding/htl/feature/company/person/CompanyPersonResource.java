package at.ac.leonding.htl.feature.company.person;

import at.ac.leonding.htl.feature.company.CompanyRepository;
import at.ac.leonding.htl.feature.company.person.dtos.PersonDto;
import at.ac.leonding.htl.feature.company.person.dtos.PersonDtoFactory;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("companies/{companyId}/persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CompanyPersonResource {
    @Inject
    PersonRepository personRepository;

    @Inject
    CompanyRepository companyRepository;

    @GET
    public List<PersonDto> listAllPersonsByCompany(@PathParam("companyId") Long companyId) {
        return PersonDtoFactory.createList(personRepository.listAllInCompany(companyId));
    }

    @Path("{personId}")
    @GET
    public Response getPerson(@PathParam("companyId") Long companyId, @PathParam("personId") Long personId) {
        Person person = personRepository.findByIdInCompany(personId, companyId);

        if (person == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(
                    PersonDtoFactory.create(person)
            ).build();
        }
    }

    @Transactional
    @POST
    public Response addPerson(@PathParam("companyId") Long companyId, Person person) {
        person.company = companyRepository.findById(companyId);
        personRepository.persist(person);

        return Response.ok().build();
    }
}
