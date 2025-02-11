package at.ac.leonding.htl.feature.company.person;

import at.ac.leonding.htl.feature.company.CompanyRepository;
import at.ac.leonding.htl.feature.company.person.dtos.PersonDto;
import at.ac.leonding.htl.feature.company.person.dtos.PersonDtoFactory;
import at.ac.leonding.htl.feature.company.ride.Ride;
import at.ac.leonding.htl.feature.company.ride.RideRepository;
import at.ac.leonding.htl.feature.company.ride.dtos.RideDto;
import at.ac.leonding.htl.feature.company.ride.dtos.RideDtoFactory;
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

    @Inject
    RideRepository rideRepository;

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

    @GET
    @Path("{personId}/hosted-rides")
    public List<RideDto> getHostedRides(
            @PathParam("companyId") Long companyId,
            @PathParam("personId") Long personId
    ) {
        return RideDtoFactory.createList(rideRepository.findRidesByHostInCompany(personId, companyId));
    }

    @Transactional
    @POST
    @Path("{personId}/hosted-rides")
    public Response hostRide(
            @PathParam("companyId") Long companyId,
            @PathParam("personId") Long personId,
            Ride ride
    ) {
        if (ride == null) {
            return Response.status(Response.Status.BAD_GATEWAY).build();
        }

        ride.host = personRepository.findByIdInCompany(personId, companyId);

        rideRepository.persist(ride);
        return Response.ok().build();
    }

    @Transactional
    @DELETE
    @Path("{personId}/hosted-rides/{rideId}")
    public Response removeHostedRide(
            @PathParam("companyId") Long companyId,
            @PathParam("personId") Long personId,
            @PathParam("rideId") Long rideId
    ) {
        Person host = personRepository.findByIdInCompany(personId, companyId);
        Ride ride = rideRepository.findByIdInCompany(rideId, companyId);

        if (ride.host == host) {
            rideRepository.delete(ride);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
