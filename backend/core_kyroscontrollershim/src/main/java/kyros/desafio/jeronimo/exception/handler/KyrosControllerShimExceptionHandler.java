package kyros.desafio.jeronimo.exception.handler;

import io.vertx.core.json.JsonObject;
import kyros.desafio.jeronimo.beans.response.ResponseTO;
import kyros.desafio.jeronimo.exception.custom.KyrosControllerShimException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class KyrosControllerShimExceptionHandler implements ExceptionMapper<KyrosControllerShimException> {
    @Override
    public Response toResponse(KyrosControllerShimException exception) {
        ResponseTO responseTO = new ResponseTO();
        JsonObject json = new JsonObject();
        json.put("code", exception.getCode());
        json.put("message", exception.getMessage());
        responseTO.setJson(json.toString());
        responseTO.setStatus(false);
        return Response.status(Response.Status.OK).entity(json).build();
    }
}
