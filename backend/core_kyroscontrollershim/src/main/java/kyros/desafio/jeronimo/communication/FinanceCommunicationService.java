package kyros.desafio.jeronimo.communication;

import kyros.desafio.jeronimo.beans.request.FinanceRequestTO;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@RegisterRestClient(baseUri = "http://localhost:8081/finances")
public interface FinanceCommunicationService {

    @GET
    Response findAllFinances();

    @GET
    @Path("/{finance_id}")
    Response findFinanceById(@PathParam("finance_id") String id);

    @POST
    Response createFinance(@RequestBody FinanceRequestTO to);
}