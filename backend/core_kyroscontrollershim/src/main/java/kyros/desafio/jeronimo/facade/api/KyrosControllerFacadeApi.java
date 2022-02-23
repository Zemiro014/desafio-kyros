package kyros.desafio.jeronimo.facade.api;

import kyros.desafio.jeronimo.beans.request.FinanceRequestTO;
import kyros.desafio.jeronimo.beans.request.ProviderRequestTO;
import kyros.desafio.jeronimo.beans.response.FinanceResponseTO;
import kyros.desafio.jeronimo.beans.response.ProviderResponseTO;
import kyros.desafio.jeronimo.exception.custom.KyrosControllerShimException;

import java.util.List;

public interface KyrosControllerFacadeApi {
    List<FinanceResponseTO> findAllFinances() throws KyrosControllerShimException;

    FinanceResponseTO findFinancesById(String id) throws KyrosControllerShimException;

    List<ProviderResponseTO> findAllProviders() throws KyrosControllerShimException;

    void createProvider(ProviderRequestTO to) throws KyrosControllerShimException;

    ProviderResponseTO findProviderById(String id) throws KyrosControllerShimException;

    void createFinance(FinanceRequestTO to) throws KyrosControllerShimException;
}
