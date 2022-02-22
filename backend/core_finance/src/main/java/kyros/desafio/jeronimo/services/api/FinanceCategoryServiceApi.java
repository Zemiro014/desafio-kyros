package kyros.desafio.jeronimo.services.api;

import kyros.desafio.jeronimo.beans.to.requestTO.FinanceCategoryRequestTO;
import kyros.desafio.jeronimo.beans.to.responseTO.FinanceCategoryResponseTO;
import kyros.desafio.jeronimo.exceptions.custom.FinanceException;

import java.util.List;

public interface FinanceCategoryServiceApi {
    List<FinanceCategoryResponseTO> findAllCategories();

    FinanceCategoryResponseTO categoryById(String id) throws FinanceException;

    void creteCategory(FinanceCategoryRequestTO to);
}