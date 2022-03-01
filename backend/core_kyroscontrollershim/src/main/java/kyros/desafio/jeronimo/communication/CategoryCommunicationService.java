package kyros.desafio.jeronimo.communication;

import kyros.desafio.jeronimo.beans.request.CategoryRequestTO;
import kyros.desafio.jeronimo.beans.request.FinanceRequestTO;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@RegisterRestClient(baseUri = "http://localhost:8081/categories")
public interface CategoryCommunicationService {

    @GET
    Response findAllFinanceCategories();

    @GET
    @Path("/{category_id}")
    Response findCategoryById(@PathParam("category_id") String id);

    @POST
    Response createCategory(@RequestBody CategoryRequestTO to);
}