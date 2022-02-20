package kyros.desafio.jeronimo.service.api;

import kyros.desafio.jeronimo.beans.response.FinanceResponseTO;
import kyros.desafio.jeronimo.exception.custom.KyrosControllerShimException;

import java.util.List;

public interface FinanceServiceApi {
    List<FinanceResponseTO> findAllFinances() throws KyrosControllerShimException;

    FinanceResponseTO findFinanceById(String id) throws KyrosControllerShimException;
}
