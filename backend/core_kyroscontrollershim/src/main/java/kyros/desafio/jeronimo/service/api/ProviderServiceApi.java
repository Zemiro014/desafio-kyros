package kyros.desafio.jeronimo.service.api;

import kyros.desafio.jeronimo.beans.request.ProviderRequestTO;
import kyros.desafio.jeronimo.beans.response.ProviderResponseTO;
import kyros.desafio.jeronimo.exception.custom.KyrosControllerShimException;

import java.util.List;

public interface ProviderServiceApi {
    List<ProviderResponseTO> findAllProviders() throws KyrosControllerShimException;

    void createProvider(ProviderRequestTO to) throws KyrosControllerShimException ;

    ProviderResponseTO findProviderById(String id) throws KyrosControllerShimException ;
}