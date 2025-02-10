package at.ac.leonding.htl.feature.company.person;

import at.ac.leonding.htl.feature.company.person.dtos.PersonDto;
import at.ac.leonding.htl.feature.company.person.dtos.PersonDtoFactory;
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
    public List<PersonDto> listAll() {
        return PersonDtoFactory.createList(personRepository.listAll());
    }

    @Path("{id}")
    @GET
    public Response getPerson(@PathParam("id") Long id) {
        Person person = personRepository.findById(id);

        if (person == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(PersonDtoFactory.create(person)).build();
        }
    }

    @Transactional
    @POST
    public Response addPerson(Person person) { // not recommended because company is not assigned
        personRepository.persist(person);
        return Response.ok().build();
    }
}
