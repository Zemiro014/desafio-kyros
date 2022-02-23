package kyros.desafio.jeronimo.facade.impl;

import kyros.desafio.jeronimo.beans.request.FinanceRequestTO;
import kyros.desafio.jeronimo.beans.request.ProviderRequestTO;
import kyros.desafio.jeronimo.beans.response.FinanceResponseTO;
import kyros.desafio.jeronimo.beans.response.ProviderResponseTO;
import kyros.desafio.jeronimo.exception.custom.KyrosControllerShimException;
import kyros.desafio.jeronimo.facade.api.KyrosControllerFacadeApi;
import kyros.desafio.jeronimo.service.api.FinanceServiceApi;
import kyros.desafio.jeronimo.service.api.ProviderServiceApi;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class KyrosControllerFacadeImpl implements KyrosControllerFacadeApi {

    @Inject
    private FinanceServiceApi financeService;

    @Inject
    private ProviderServiceApi providerService;

    @Override
    public List<FinanceResponseTO> findAllFinances() throws KyrosControllerShimException {
        return financeService.findAllFinances();
    }

    @Override
    public FinanceResponseTO findFinancesById(String id) throws KyrosControllerShimException {
        return financeService.findFinanceById(id);
    }

    @Override
    public void createFinance(FinanceRequestTO to) throws KyrosControllerShimException {
        financeService.createFinance(to);
    }

    @Override
    public List<ProviderResponseTO> findAllProviders() throws KyrosControllerShimException {
        return providerService.findAllProviders();
    }

    @Override
    public void createProvider(ProviderRequestTO to) throws KyrosControllerShimException {
        providerService.createProvider(to);
    }

    @Override
    public ProviderResponseTO findProviderById(String id) throws KyrosControllerShimException {
        return providerService.findProviderById(id);
    }

}
