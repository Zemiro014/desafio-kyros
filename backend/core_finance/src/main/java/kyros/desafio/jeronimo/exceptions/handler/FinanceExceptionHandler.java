package kyros.desafio.jeronimo.exceptions.handler;

import io.vertx.core.json.JsonObject;
import kyros.desafio.jeronimo.beans.to.responseTO.ResponseTO;
import kyros.desafio.jeronimo.exceptions.custom.FinanceException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class FinanceExceptionHandler implements ExceptionMapper<FinanceException> {

    @Override
    public Response toResponse(FinanceException exception) {
        ResponseTO responseTO = new ResponseTO();
        JsonObject json = new JsonObject();
        json.put("code", exception.getCode());
        json.put("message", exception.getMessage());
        responseTO.setJson(json.toString());
        return Response.status(Response.Status.OK).entity(json).build();
    }
}
