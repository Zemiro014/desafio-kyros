package kyros.desafio.jeronimo.dao.impl.postgresdb;

import kyros.desafio.jeronimo.dao.api.postgres.ProviderPostgresDaoApi;
import kyros.desafio.jeronimo.entities.Address;
import kyros.desafio.jeronimo.entities.Provider;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class ProviderPostgresDaoImpl implements ProviderPostgresDaoApi {

     @Inject
     EntityManager em;

    @Override
    public void create(Provider entity) {
        Address address = entity.getProviderAddress();
        address.setId(UUID.randomUUID().toString());
        em.persist(address);
        em.persist(entity);
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Provider findById(String id) {
        return em.find(Provider.class, id);
    }

    @Override
    public List<Provider> findAll() {
        return em.createQuery("from Provider", Provider.class).getResultList();
    }

    @Override
    public void update(Provider entity) {

    }
}
