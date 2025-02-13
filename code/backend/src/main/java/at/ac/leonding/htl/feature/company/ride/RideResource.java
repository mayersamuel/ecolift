package at.ac.leonding.htl.feature.company.ride;

import at.ac.leonding.htl.feature.company.ride.dtos.RideDto;
import at.ac.leonding.htl.feature.company.ride.dtos.RideDtoFactory;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("rides")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RideResource {
    @Inject
    RideRepository rideRepository;

    @GET
    public List<RideDto> listAll() {
        return RideDtoFactory.createList(rideRepository.listAll());
    }

    @Path("{id}")
    @GET
    public Response getRide(@PathParam("id") Long id) {
        Ride ride = rideRepository.findById(id);

        if (ride == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(
                    RideDtoFactory.create(ride)
            ).build();
        }
    }

    @Transactional
    @POST
    public Response addRide(Ride ride) {
        rideRepository.persist(ride);
        return Response.ok().build();
    }
}
