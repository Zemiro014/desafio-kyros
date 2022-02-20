package kyros.desafio.jeronimo.web;

import kyros.desafio.jeronimo.beans.request.ProviderRequestTO;
import kyros.desafio.jeronimo.beans.response.FinanceResponseTO;
import kyros.desafio.jeronimo.beans.response.ProviderResponseTO;
import kyros.desafio.jeronimo.exception.custom.KyrosControllerShimException;
import kyros.desafio.jeronimo.facade.api.KyrosControllerFacadeApi;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("provider")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProviderRestFull {

    @Inject
    KyrosControllerFacadeApi facade;

    @GET
    public Response findAllProviders() throws KyrosControllerShimException {
        List<ProviderResponseTO> providers = facade.findAllProviders();
        return Response.ok().build();
    }

    @GET
    @Path("/{provider_id}")
    public Response findProviderById(@PathParam("provider_id") String id) throws KyrosControllerShimException{
        ProviderResponseTO responseTO = facade.findProviderById(id);
        return Response.ok().build();
    }

    @POST
    public Response createProvider(@Valid ProviderRequestTO to) throws KyrosControllerShimException{
        facade.createProvider(to);
        return Response.ok().build();
    }
}