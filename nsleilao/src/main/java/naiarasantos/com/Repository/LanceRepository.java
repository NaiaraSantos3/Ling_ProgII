package naiarasantos.com.Repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import naiarasantos.com.Entity.Lance;

@ApplicationScoped
public class LanceRepository {
    @Inject
    @PersistenceContext
    EntityManager em;

    public Lance findByIdLance(Integer idLance) {
        return em.createQuery("select l from Lance l where l.idLance = :idLance", Lance.class)
                .setParameter("idLance", idLance)
                .getSingleResult();
    }
}





