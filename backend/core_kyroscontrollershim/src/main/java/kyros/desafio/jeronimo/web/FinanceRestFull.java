package kyros.desafio.jeronimo.web;

import kyros.desafio.jeronimo.beans.request.FinanceRequestTO;
import kyros.desafio.jeronimo.beans.response.FinanceResponseTO;
import kyros.desafio.jeronimo.exception.custom.KyrosControllerShimException;
import kyros.desafio.jeronimo.facade.api.KyrosControllerFacadeApi;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("finances")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FinanceRestFull {

    @Inject
    KyrosControllerFacadeApi facadeApi;

    @GET
    public Response findAllFinances() throws KyrosControllerShimException {
        List<FinanceResponseTO> finances = facadeApi.findAllFinances();
        return Response.ok().entity(finances).build();
    }
    @GET
    @Path("/{finance_id}")
    public Response findFinancesById(@PathParam("finance_id") String id) throws KyrosControllerShimException {
        FinanceResponseTO finance = facadeApi.findFinancesById(id);
        return Response.ok().entity(finance).build();
    }
    @POST
    public Response createFinance(@RequestBody FinanceRequestTO to) throws KyrosControllerShimException {
        facadeApi.createFinance(to);
        return Response.status(Response.Status.CREATED).build();
    }
}
