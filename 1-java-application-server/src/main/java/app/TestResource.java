package app;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("")
public class TestResource {

	@Inject
	private TestService service;

	@GET
	@Path("/test/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response test(@PathParam("id") String id) {
		try {
			TestPojo result = service.create(id);
			return Response.ok(result).type(MediaType.APPLICATION_JSON).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}

}
