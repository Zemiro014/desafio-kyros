package kyros.desafio.jeronimo.web;

import kyros.desafio.jeronimo.beans.request.CategoryRequestTO;
import kyros.desafio.jeronimo.beans.response.CategoryResponseTO;
import kyros.desafio.jeronimo.exception.custom.KyrosControllerShimException;
import kyros.desafio.jeronimo.facade.api.KyrosControllerFacadeApi;

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
public class CategoryRestFull {
    @Inject
    KyrosControllerFacadeApi facade;

    @GET
    public Response findAllCategories() throws KyrosControllerShimException {
        List<CategoryResponseTO> categories = facade.findAllCategories();
        return Response.ok().entity(categories).build();
    }
    @GET
    @Path("/{category_id}")
    public Response findCategoryById(@PathParam("category_id") String id) throws KyrosControllerShimException {
        CategoryResponseTO category = facade.findCategoryById(id);
        return Response.ok().entity(category).build();
    }

    @POST
    public Response createCategory(@Valid CategoryRequestTO to) throws KyrosControllerShimException{
        facade.createCategory(to);
        return Response.ok().status(Response.Status.CREATED).build();
    }
}
