package kyros.desafio.jeronimo.dao.impl.postgres;

import kyros.desafio.jeronimo.dao.api.postgres.FinanceCategoryDaoApi;
import kyros.desafio.jeronimo.entities.FinanceCategory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FinanceCategoryDaoImpl implements FinanceCategoryDaoApi {

    @Inject
    private EntityManager em;

    @Override
    public void create(FinanceCategory entity) {
        em.persist(entity);
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public FinanceCategory findById(String id) {
        return em.find(FinanceCategory.class, id);
    }

    @Override
    public List<FinanceCategory> findAll() {
        return em.createQuery("from FinanceCategory", FinanceCategory.class).getResultList();
    }

    @Override
    public void update(FinanceCategory entity) {

    }
}
