package kyros.desafio.jeronimo;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Set;

@Path("/hello")
public class GreetingResource {

    @Inject
    @RestClient
    MyRemoteService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }

    @GET
    @Path("/extensions")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response communicationRemote(@QueryParam("id") String id){
        Set<MyRemoteService.Extension> extension = service.getExtensionsById(id);
        return Response.ok().entity(extension).build();
    }
}