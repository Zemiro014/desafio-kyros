package kyros.desafio.jeronimo.facade.api;

import kyros.desafio.jeronimo.beans.to.requestTO.FinanceCategoryRequestTO;
import kyros.desafio.jeronimo.beans.to.requestTO.FinanceRequestTO;
import kyros.desafio.jeronimo.beans.to.responseTO.FinanceCategoryResponseTO;
import kyros.desafio.jeronimo.beans.to.responseTO.FinanceResponseTO;
import kyros.desafio.jeronimo.exceptions.custom.FinanceException;

import java.util.List;

public interface FacadeFinanceApi {
    List<FinanceResponseTO> findAllFinances();

    void createFinance(FinanceRequestTO to) throws FinanceException;

    FinanceResponseTO findFinanceById(String id) throws FinanceException;

    List<FinanceCategoryResponseTO> findAllFinanceCategories();

    FinanceCategoryResponseTO findCategoryById(String id) throws FinanceException;

    void createCategory(FinanceCategoryRequestTO to);
}