package kyros.desafio.jeronimo.service.impl;

import kyros.desafio.jeronimo.beans.request.CategoryRequestTO;
import kyros.desafio.jeronimo.beans.response.CategoryResponseTO;
import kyros.desafio.jeronimo.communication.CategoryCommunicationService;
import kyros.desafio.jeronimo.constants.KyrosControllerExceptionConstants;
import kyros.desafio.jeronimo.exception.custom.KyrosControllerShimException;
import kyros.desafio.jeronimo.service.api.CategoryServiceApi;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
public class CategoryServiceImpl implements CategoryServiceApi {

    @RestClient
    @Inject
    private CategoryCommunicationService categoryCommunication;

    @Override
    public List<CategoryResponseTO> findAllCategories() throws KyrosControllerShimException {
        List<CategoryResponseTO> categories = null;
        Response response = null;
        try{
            response = categoryCommunication.findAllFinanceCategories();
            if(response.getStatus() != 200)
                throw new KyrosControllerShimException(KyrosControllerExceptionConstants.ERROR_CORE_MICROSERVICE_NOT_FOUND, "Finance");
            categories = response.readEntity(List.class);
        } catch (Exception e ){
            throw new KyrosControllerShimException(KyrosControllerExceptionConstants.ERROR_CORE_MICROSERVICE_NOT_FOUND, "Finance");
        }
        return categories;
    }

    @Override
    public CategoryResponseTO findCategoryById(String id) throws KyrosControllerShimException {
        CategoryResponseTO provider = null;
        Response response = null;
        try{
            response = categoryCommunication.findCategoryById(id);
            if(response.getStatus() != 200)
                throw new KyrosControllerShimException(KyrosControllerExceptionConstants.ERROR_CORE_MICROSERVICE_NOT_FOUND, "Finance");
            provider = response.readEntity(CategoryResponseTO.class);
        } catch (Exception e ){
            throw new KyrosControllerShimException(KyrosControllerExceptionConstants.ERROR_CORE_MICROSERVICE_NOT_FOUND, "Finance");
        }
        return provider;
    }

    @Override
    public void createCategory(CategoryRequestTO to) throws KyrosControllerShimException {
        Response response = null;
        try{
            response = categoryCommunication.createCategory(to);
            if(response.getStatus() != 200)
                throw new KyrosControllerShimException(KyrosControllerExceptionConstants.ERROR_CORE_MICROSERVICE_NOT_FOUND, "Finance");
        } catch (Exception e ){
            throw new KyrosControllerShimException(KyrosControllerExceptionConstants.ERROR_CORE_MICROSERVICE_NOT_FOUND, "Finance");
        }
    }
}
