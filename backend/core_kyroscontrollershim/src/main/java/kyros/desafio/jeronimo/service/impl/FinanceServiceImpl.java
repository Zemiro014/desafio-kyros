package kyros.desafio.jeronimo.service.impl;

import kyros.desafio.jeronimo.beans.response.FinanceResponseTO;
import kyros.desafio.jeronimo.communication.FinanceCommunicationService;
import kyros.desafio.jeronimo.constants.KyrosControllerExceptionConstants;
import kyros.desafio.jeronimo.exception.custom.KyrosControllerShimException;
import kyros.desafio.jeronimo.service.api.FinanceServiceApi;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class FinanceServiceImpl implements FinanceServiceApi {

    @RestClient
    @Inject
    FinanceCommunicationService financeCommunication;

    @Override
    public List<FinanceResponseTO> findAllFinances() throws KyrosControllerShimException {
        List<FinanceResponseTO> finances = new ArrayList<>();
        Response response = null;
        try{
            response = financeCommunication.findAllFinances();
        } catch (Exception e ){
            System.out.println("Status ===> "+e.getMessage());
            throw new KyrosControllerShimException(KyrosControllerExceptionConstants.ERROR_CORE_MICROSERVICE_NOT_FOUND, "Finance");
    }
        return finances;
    }

    @Override
    public FinanceResponseTO findFinanceById(String id) throws KyrosControllerShimException {
        FinanceResponseTO responseTO = new FinanceResponseTO();
        Response response = null;
        try{
            response = financeCommunication.findFinanceById(id);
        }
        catch (Exception e){
            System.out.println("Status ===> "+e.getMessage());
            throw new KyrosControllerShimException(KyrosControllerExceptionConstants.ERROR_CORE_MICROSERVICE_NOT_FOUND, "Finance");
        }
        return responseTO;
    }
}
