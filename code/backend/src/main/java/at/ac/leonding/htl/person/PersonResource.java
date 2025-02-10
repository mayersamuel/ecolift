package at.ac.leonding.htl.person;

import at.ac.leonding.htl.feature.company.Company;
import at.ac.leonding.htl.ride.Ride;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {
    @Inject
    PersonRepository personRepository;

    @GET
    public List<Person> listAll() {
        return personRepository.listAll();
    }

    @Path("{id}")
    @GET
    public Response getPerson(@PathParam("id") Long id) {
        Person person = personRepository.findById(id);

        if (person == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(person).build();
        }
    }

    @Transactional
    @POST
    public Response addPerson(Person person) {
        personRepository.persist(person);
        return Response.ok().build();
    }
}
