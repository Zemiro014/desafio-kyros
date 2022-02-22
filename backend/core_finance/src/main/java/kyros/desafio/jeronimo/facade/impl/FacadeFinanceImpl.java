package kyros.desafio.jeronimo.facade.impl;

import kyros.desafio.jeronimo.beans.to.requestTO.FinanceCategoryRequestTO;
import kyros.desafio.jeronimo.beans.to.requestTO.FinanceRequestTO;
import kyros.desafio.jeronimo.beans.to.responseTO.FinanceCategoryResponseTO;
import kyros.desafio.jeronimo.beans.to.responseTO.FinanceResponseTO;
import kyros.desafio.jeronimo.exceptions.custom.FinanceException;
import kyros.desafio.jeronimo.facade.api.FacadeFinanceApi;
import kyros.desafio.jeronimo.services.api.FinanceCategoryServiceApi;
import kyros.desafio.jeronimo.services.api.FinanceServiceApi;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class FacadeFinanceImpl implements FacadeFinanceApi {

    @Inject
    private FinanceServiceApi financeService;

    @Inject
    private FinanceCategoryServiceApi categoryService;

    @Override
    public List<FinanceResponseTO> findAllFinances() {
        return financeService.findAll();
    }

    @Override
    @Transactional
    public void createFinance(FinanceRequestTO to) {
        financeService.createFinance(to);
    }

    @Override
    public FinanceResponseTO findFinanceById(String id) throws FinanceException {
        return financeService.findById(id);
    }

    @Override
    public List<FinanceCategoryResponseTO> findAllFinanceCategories() {
        return categoryService.findAllCategories();
    }

    @Override
    public FinanceCategoryResponseTO findCategoryById(String id) throws FinanceException {
        return categoryService.categoryById(id);
    }

    @Override
    public void createCategory(FinanceCategoryRequestTO to) {
        categoryService.creteCategory(to);
    }
}