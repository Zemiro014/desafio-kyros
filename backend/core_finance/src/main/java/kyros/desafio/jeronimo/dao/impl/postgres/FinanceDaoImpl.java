package kyros.desafio.jeronimo.dao.impl.postgres;

import kyros.desafio.jeronimo.beans.vo.FinanceVO;
import kyros.desafio.jeronimo.dao.api.postgres.FinanceDaoApi;
import kyros.desafio.jeronimo.entities.Finance;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FinanceDaoImpl implements FinanceDaoApi {

    @Inject
    private EntityManager em;

    @Override
    public void create(Finance entity) {
        em.persist(entity);
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Finance findById(String id) {
        return em.find(Finance.class, id);
    }

    @Override
    public List<Finance> findAll() {
        return em.createQuery("from Finance", Finance.class).getResultList();
    }

    @Override
    public void update(Finance entity) {

    }
}