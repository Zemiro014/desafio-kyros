package kyros.desafio.jeronimo.service.impl;

import kyros.desafio.jeronimo.beans.request.FinanceRequestTO;
import kyros.desafio.jeronimo.beans.response.FinanceResponseTO;
import kyros.desafio.jeronimo.communication.FinanceCommunicationService;
import kyros.desafio.jeronimo.constants.KyrosControllerExceptionConstants;
import kyros.desafio.jeronimo.exception.custom.KyrosControllerShimException;
import kyros.desafio.jeronimo.service.api.FinanceServiceApi;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
public class FinanceServiceImpl implements FinanceServiceApi {

    @RestClient
    @Inject
    FinanceCommunicationService financeCommunication;

    @Override
    public List<FinanceResponseTO> findAllFinances() throws KyrosControllerShimException {
        List finances = null;
        Response response = null;
        try{
            response = financeCommunication.findAllFinances();
            if(response.getStatus() != 200)
                throw new KyrosControllerShimException(KyrosControllerExceptionConstants.ERROR_CORE_MICROSERVICE_NOT_FOUND, "Finance");
            finances = response.readEntity(List.class);
        } catch (Exception e ){
            throw new KyrosControllerShimException(KyrosControllerExceptionConstants.ERROR_CORE_MICROSERVICE_NOT_FOUND, "Finance");
    }
        return finances;
    }

    @Override
    public FinanceResponseTO findFinanceById(String id) throws KyrosControllerShimException {
        FinanceResponseTO responseTO = null;
        Response response = null;
        try{
            response = financeCommunication.findFinanceById(id);
            responseTO = response.readEntity(FinanceResponseTO.class);
        }
        catch (Exception e){
            System.out.println("Status ===> "+e.getMessage());
            throw new KyrosControllerShimException(KyrosControllerExceptionConstants.ERROR_CORE_MICROSERVICE_NOT_FOUND, "Finance");
        }
        return responseTO;
    }

    @Override
    public void createFinance(FinanceRequestTO to) throws KyrosControllerShimException {
        Response response = null;
        try {
            response = financeCommunication.createFinance(to);
            if (response.getStatus() != 200)
                throw new KyrosControllerShimException(KyrosControllerExceptionConstants.ERROR_CORE_MICROSERVICE_NOT_FOUND, "Finance");
        }
        catch (Exception e){
            throw new KyrosControllerShimException(KyrosControllerExceptionConstants.ERROR_CORE_MICROSERVICE_NOT_FOUND, "Finance");
        }
    }
}
