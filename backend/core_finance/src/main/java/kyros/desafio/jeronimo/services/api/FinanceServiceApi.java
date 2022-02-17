package kyros.desafio.jeronimo.services.api;

import kyros.desafio.jeronimo.beans.to.requestTO.FinanceRequestTO;
import kyros.desafio.jeronimo.beans.to.responseTO.FinanceResponseTO;
import kyros.desafio.jeronimo.exceptions.custom.FinanceException;

import java.util.List;

public interface FinanceServiceApi {
    void createFinance(FinanceRequestTO to);

    List<FinanceResponseTO> findAll();

    FinanceResponseTO findById(String id) throws FinanceException;
}
