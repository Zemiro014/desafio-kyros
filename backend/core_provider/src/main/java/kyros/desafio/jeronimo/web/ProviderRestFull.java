package kyros.desafio.jeronimo.web;

import kyros.desafio.jeronimo.beans.to.request.CreateProviderRequestTO;
import kyros.desafio.jeronimo.beans.to.response.ProviderResponseTO;
import kyros.desafio.jeronimo.exception.custom.ProviderException;
import kyros.desafio.jeronimo.facade.api.ProviderFacadeApi;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("providers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProviderRestFull {

    @Inject
    ProviderFacadeApi facadeApi;

    @GET
    public Response findAllProviders(){
        List<ProviderResponseTO> providers = facadeApi.findAllProviders();
        return Response.ok().entity(providers).build();
    }

    @GET
    @Path("/{provider_id}")
    public Response findProviderById(@PathParam("provider_id") String id) throws ProviderException{
        ProviderResponseTO provider = facadeApi.findProviderById(id);
        return Response.ok().entity(provider).build();
    }

    @POST
    @Transactional
    public Response createProvider(@Valid CreateProviderRequestTO to) throws ProviderException {
        System.out.println("Nome ===> "+to .getProviderName());
        facadeApi.createProvider(to);
        return Response.status(Response.Status.CREATED).build();
    }
}
