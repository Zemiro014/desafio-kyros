package kyros.desafio.jeronimo.web;

import kyros.desafio.jeronimo.beans.response.FinanceResponseTO;
import kyros.desafio.jeronimo.exception.custom.KyrosControllerShimException;
import kyros.desafio.jeronimo.facade.api.KyrosControllerFacadeApi;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("finance")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FinanceRestFull {

    @Inject
    KyrosControllerFacadeApi facadeApi;

    @GET
    public Response findAllFinances() throws KyrosControllerShimException {
        List<FinanceResponseTO> finances = facadeApi.findAllFinances();
        return Response.ok().build();
    }
    @GET
    @Path("/{finance_id}")
    public Response findFinancesById(@PathParam("finance_id") String id) throws KyrosControllerShimException {
        FinanceResponseTO finances = facadeApi.findFinancesById(id);
        return Response.ok().build();
    }
}
