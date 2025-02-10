package at.ac.leonding.htl.feature.company;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("companies")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CompanyResource {
    @Inject
    CompanyRepository companyRepository;

    @GET
    public List<Company> listAll() {
        return companyRepository.listAll();
    }

    @Path("{id}")
    @GET
    public Response getCompany(@PathParam("id") Long id) {
        Company company = companyRepository.findById(id);

        if (company == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(company).build();
        }
    }

    @Transactional
    @POST
    public Response addCompany(Company company) {
        companyRepository.persist(company);
        return Response.ok().build();
    }
}
