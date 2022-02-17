package kyros.desafio.jeronimo.facade.impl;

import kyros.desafio.jeronimo.beans.to.request.CreateProviderRequestTO;
import kyros.desafio.jeronimo.beans.to.response.ProviderResponseTO;
import kyros.desafio.jeronimo.exception.custom.ProviderException;
import kyros.desafio.jeronimo.facade.api.ProviderFacadeApi;
import kyros.desafio.jeronimo.service.api.ProviderServiceApi;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ProviderFacadeImpl implements ProviderFacadeApi {

    @Inject
    private ProviderServiceApi providerService;

    @Override
    public void createProvider(CreateProviderRequestTO to) throws ProviderException {
        providerService.createProvider(to);
    }

    @Override
    public List<ProviderResponseTO> findAllProviders() {
        return providerService.findAllProviders();
    }

    @Override
    public ProviderResponseTO findProviderById(String id) throws ProviderException {
        return providerService.findProviderById(id);
    }
}