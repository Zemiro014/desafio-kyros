package kyros.desafio.jeronimo.web;

import kyros.desafio.jeronimo.beans.to.requestTO.FinanceCategoryRequestTO;
import kyros.desafio.jeronimo.beans.to.responseTO.FinanceCategoryResponseTO;
import kyros.desafio.jeronimo.beans.to.responseTO.FinanceResponseTO;
import kyros.desafio.jeronimo.exceptions.custom.FinanceException;
import kyros.desafio.jeronimo.facade.api.FacadeFinanceApi;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("categories")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FinanceCategoryRestfull {

    @Inject
    FacadeFinanceApi facade;

    @GET
    public Response findAllFinanceCategories(){
        List<FinanceCategoryResponseTO> categories = facade.findAllFinanceCategories();
        return Response.ok().entity(categories).build();
    }

    @GET
    @Path("/{category_id}")
    public Response findCategoryById(@PathParam("category_id") String id) throws FinanceException {
        FinanceCategoryResponseTO category = facade.findCategoryById(id);
        return Response.ok().entity(category).build();
    }

    @POST
    @Path("/{category_id}")
    @Transactional
    public Response createCategory(@Valid FinanceCategoryRequestTO to){
        facade.createCategory(to);
        return Response.ok().status(Response.Status.CREATED).build();
    }
}
