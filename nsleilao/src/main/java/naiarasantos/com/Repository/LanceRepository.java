package naiarasantos.com.Repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import naiarasantos.com.Entity.Cliente;
import naiarasantos.com.Entity.Lance;

import java.util.List;

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
    public List<Lance> listAll() {
        return em.createQuery("select l from Lance l", Lance.class)
                .getResultList();
    }

}







