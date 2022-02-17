package kyros.desafio.jeronimo.services.impl;

import com.google.common.base.Strings;
import kyros.desafio.jeronimo.beans.to.requestTO.FinanceRequestTO;
import kyros.desafio.jeronimo.beans.to.responseTO.FinanceResponseTO;
import kyros.desafio.jeronimo.constants.FinanceExceptionConstants;
import kyros.desafio.jeronimo.dao.api.postgres.FinanceDaoApi;
import kyros.desafio.jeronimo.entities.Finance;
import kyros.desafio.jeronimo.exceptions.custom.FinanceException;
import kyros.desafio.jeronimo.services.api.FinanceServiceApi;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
public class FinanceServiceImpl implements FinanceServiceApi {

    @Inject
    private FinanceDaoApi financeDaoApi;

    @Override
    public void createFinance(FinanceRequestTO to) {
        Finance entity = convertToFinance(to);
        if(Strings.isNullOrEmpty(entity.getId()))
            entity.setId(UUID.randomUUID().toString());
        financeDaoApi.create(entity);
    }

    @Override
    public List<FinanceResponseTO> findAll() {
        List<Finance> finances = financeDaoApi.findAll();
        return finances.stream().map(ent -> convertToFinance(ent)).collect(Collectors.toList());
    }

    @Override
    public FinanceResponseTO findById(String id) throws FinanceException {
        Finance entity = financeDaoApi.findById(id);
        if (entity == null )
            throw new FinanceException(FinanceExceptionConstants.ERROR_CODE_FINANCE_NOT_FOUND, id);
        return convertToFinance(entity);
    }

    private Finance convertToFinance(FinanceRequestTO to){
        Finance financeEntity = new Finance();
        financeEntity.setFinanceType(to.getFinanceType());
        financeEntity.setDescription(to.getDescription());
        financeEntity.setDueData(to.getDueData());
        financeEntity.setStatus(to.getStatus());
        financeEntity.setPaymentData(to.getPaymentData());
        financeEntity.setValue(to.getValue());
        return financeEntity;
    }
    private FinanceResponseTO convertToFinance(Finance entity){
        FinanceResponseTO responseTO = new FinanceResponseTO();
        responseTO.setId(entity.getId());
        responseTO.setFinanceType(entity.getFinanceType());
        responseTO.setDescription(entity.getDescription());
        responseTO.setDueData(entity.getDueData());
        responseTO.setStatus(entity.getStatus());
        responseTO.setPaymentData(entity.getPaymentData());
        responseTO.setValue(entity.getValue());
        return responseTO;
    }
}