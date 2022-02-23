package kyros.desafio.jeronimo.service.impl;

import kyros.desafio.jeronimo.beans.request.ProviderRequestTO;
import kyros.desafio.jeronimo.beans.response.ProviderResponseTO;
import kyros.desafio.jeronimo.communication.ProviderCommunicationService;
import kyros.desafio.jeronimo.constants.KyrosControllerExceptionConstants;
import kyros.desafio.jeronimo.exception.custom.KyrosControllerShimException;
import kyros.desafio.jeronimo.service.api.ProviderServiceApi;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ProviderServiceImpl implements ProviderServiceApi {

    @RestClient
    @Inject
    private ProviderCommunicationService providerCommunication;

    @Override
    public List<ProviderResponseTO> findAllProviders() throws KyrosControllerShimException {
        List<ProviderResponseTO> providers = new ArrayList<>();
        Response response = null;
        try{
            response = providerCommunication.findAllProviders();
            if(response.getStatus() != 200)
                throw new KyrosControllerShimException(KyrosControllerExceptionConstants.ERROR_CORE_MICROSERVICE_NOT_FOUND, "Provider");
        } catch (Exception e ){
            System.out.println("Status ===> "+e.getMessage());
            throw new KyrosControllerShimException(KyrosControllerExceptionConstants.ERROR_CORE_MICROSERVICE_NOT_FOUND, "Provider");
        }
        return providers;
    }

    @Override
    public void createProvider(ProviderRequestTO to) throws KyrosControllerShimException {
        Response response = null;
        try{
            response = providerCommunication.createProvider(to);
            if(response.getStatus() != 200)
                throw new KyrosControllerShimException(KyrosControllerExceptionConstants.ERROR_CORE_MICROSERVICE_NOT_FOUND, "Provider");
        } catch (Exception e ){
            System.out.println("Status ===> "+e.getMessage());
            throw new KyrosControllerShimException(KyrosControllerExceptionConstants.ERROR_CORE_MICROSERVICE_NOT_FOUND, "Provider");
        }
    }

    @Override
    public ProviderResponseTO findProviderById(String id) throws KyrosControllerShimException {
        ProviderResponseTO provider = null;
        Response response = null;
        try{
            response = providerCommunication.findProviderById(id);
            if(response.getStatus() != 200)
                throw new KyrosControllerShimException(KyrosControllerExceptionConstants.ERROR_CORE_MICROSERVICE_NOT_FOUND, "Provider");
            provider = response.readEntity(ProviderResponseTO.class);
        } catch (Exception e ){
            System.out.println("Status ===> "+e.getMessage());
            throw new KyrosControllerShimException(KyrosControllerExceptionConstants.ERROR_CORE_MICROSERVICE_NOT_FOUND, "Provider");
        }
        return provider;
    }
}
