package kyros.desafio.jeronimo.facade.api;

import kyros.desafio.jeronimo.beans.to.request.CreateProviderRequestTO;
import kyros.desafio.jeronimo.beans.to.response.ProviderResponseTO;
import kyros.desafio.jeronimo.exception.custom.ProviderException;

import java.util.List;

public interface ProviderFacadeApi {
    void createProvider(CreateProviderRequestTO to) throws ProviderException;

    List<ProviderResponseTO> findAllProviders();

    ProviderResponseTO findProviderById(String id) throws ProviderException;
}
