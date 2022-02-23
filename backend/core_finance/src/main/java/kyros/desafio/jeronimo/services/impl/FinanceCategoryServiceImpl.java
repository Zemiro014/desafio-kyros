package kyros.desafio.jeronimo.services.impl;

import com.google.common.base.Strings;
import kyros.desafio.jeronimo.beans.to.requestTO.FinanceCategoryRequestTO;
import kyros.desafio.jeronimo.beans.to.responseTO.FinanceCategoryResponseTO;
import kyros.desafio.jeronimo.constants.FinanceExceptionConstants;
import kyros.desafio.jeronimo.dao.api.postgres.FinanceCategoryDaoApi;
import kyros.desafio.jeronimo.entities.FinanceCategory;
import kyros.desafio.jeronimo.exceptions.custom.FinanceException;
import kyros.desafio.jeronimo.services.api.FinanceCategoryServiceApi;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
public class FinanceCategoryServiceImpl implements FinanceCategoryServiceApi {

    @Inject
    private FinanceCategoryDaoApi dao;

    @Override
    public List<FinanceCategoryResponseTO> findAllCategories() {
        return dao.findAll().stream().map(this::convertEntityToResponse).collect(Collectors.toList());
    }

    @Override
    public FinanceCategoryResponseTO categoryById(String id) throws FinanceException {
        System.out.println(id);
        FinanceCategory entity = dao.findById(id);
        System.out.println(entity.getCategory());
        if (entity == null )
            throw new FinanceException(FinanceExceptionConstants.ERROR_CODE_FINANCE_CATEGORY_NOT_FOUND, id);
        return convertEntityToResponse(entity);
    }

    @Override
    public void creteCategory(FinanceCategoryRequestTO to) {
        FinanceCategory entity = convertRequestToEntity(to);
        if(Strings.isNullOrEmpty(entity.getId()))
            entity.setId(UUID.randomUUID().toString());
        dao.create(entity);
    }

    private FinanceCategory convertRequestToEntity(FinanceCategoryRequestTO to){
        FinanceCategory entity = new FinanceCategory();
        entity.setCategory(to.getCategory());
        return entity;
    }

    private FinanceCategoryResponseTO convertEntityToResponse(FinanceCategory entity){
        FinanceCategoryResponseTO response = new FinanceCategoryResponseTO();
        response.setCategory(entity.getCategory());
        response.setId(entity.getId());
        return response;
    }
}
