package at.ac.leonding.htl.feature.company.ride;

import at.ac.leonding.htl.feature.company.CompanyRepository;
import at.ac.leonding.htl.feature.company.ride.dtos.RideDto;
import at.ac.leonding.htl.feature.company.ride.dtos.RideDtoFactory;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("companies/{companyId}/rides")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CompanyRideResource {
    @Inject
    RideRepository rideRepository;

    @GET
    public List<RideDto> listAllPersonsByCompany(@PathParam("companyId") Long companyId) {
        return RideDtoFactory.createList(rideRepository.listAllInCompany(companyId));
    }

    @Path("{rideId}")
    @GET
    public Response getPerson(@PathParam("companyId") Long companyId, @PathParam("rideId") Long rideId) {
        Ride ride = rideRepository.findByIdInCompany(rideId, companyId);

        if (ride == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(
                    RideDtoFactory.create(ride)
            ).build();
        }
    }
}
