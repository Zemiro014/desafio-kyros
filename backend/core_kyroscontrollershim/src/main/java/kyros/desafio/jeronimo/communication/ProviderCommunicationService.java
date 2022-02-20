package kyros.desafio.jeronimo.communication;

import kyros.desafio.jeronimo.beans.request.ProviderRequestTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@RegisterRestClient(baseUri = "http://localhost:8080/providers")
public interface ProviderCommunicationService {

    @GET
    Response findAllProviders();

    @GET
    @Path("/{provider_id}")
    Response findProviderById(@PathParam("provider_id") String id);

    @POST
    Response createProvider(@Valid ProviderRequestTO to);
}
