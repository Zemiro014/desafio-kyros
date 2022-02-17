package kyros.desafio.jeronimo.web;

import kyros.desafio.jeronimo.beans.to.requestTO.FinanceRequestTO;
import kyros.desafio.jeronimo.beans.to.responseTO.FinanceResponseTO;
import kyros.desafio.jeronimo.exceptions.custom.FinanceException;
import kyros.desafio.jeronimo.facade.api.FacadeFinanceApi;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("finances")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FinanceRestfull {

    @Inject
    FacadeFinanceApi facadeFinance;

    @GET
    public Response findAllFinances(){
        List<FinanceResponseTO> responseTO = facadeFinance.findAllFinances();
        return Response.ok().entity(responseTO).build();
    }

    @GET
    @Path("/{finance_id}")
    public Response findFinanceById(@PathParam("finance_id") String id) throws FinanceException {
        FinanceResponseTO responseTO = facadeFinance.findFinanceById(id);
        return  Response.ok().entity(responseTO).build();
    }

    @POST
    public Response createFinance(FinanceRequestTO to){
        facadeFinance.createFinance(to);
        return Response.status(Response.Status.CREATED).build();
    }
}