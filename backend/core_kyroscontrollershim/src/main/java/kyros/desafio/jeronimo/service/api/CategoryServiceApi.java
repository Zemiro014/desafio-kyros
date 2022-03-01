package kyros.desafio.jeronimo.service.api;

import kyros.desafio.jeronimo.beans.request.CategoryRequestTO;
import kyros.desafio.jeronimo.beans.response.CategoryResponseTO;
import kyros.desafio.jeronimo.exception.custom.KyrosControllerShimException;

import java.util.List;

public interface CategoryServiceApi {
    List<CategoryResponseTO> findAllCategories() throws KyrosControllerShimException;

    CategoryResponseTO findCategoryById(String id) throws KyrosControllerShimException;

    void createCategory(CategoryRequestTO to) throws KyrosControllerShimException;
}
