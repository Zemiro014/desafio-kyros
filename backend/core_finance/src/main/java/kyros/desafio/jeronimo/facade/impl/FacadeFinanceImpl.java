package kyros.desafio.jeronimo.facade.impl;

import kyros.desafio.jeronimo.beans.to.requestTO.FinanceRequestTO;
import kyros.desafio.jeronimo.beans.to.responseTO.FinanceResponseTO;
import kyros.desafio.jeronimo.exceptions.custom.FinanceException;
import kyros.desafio.jeronimo.facade.api.FacadeFinanceApi;
import kyros.desafio.jeronimo.services.api.FinanceServiceApi;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class FacadeFinanceImpl implements FacadeFinanceApi {

    @Inject
    private FinanceServiceApi financeService;

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
}