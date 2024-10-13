package naiarasantos.com.Repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import naiarasantos.com.Entity.Lance;

import java.util.List;

@ApplicationScoped
public class LanceRepository {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public void cadastrarLance(Lance lance) {
        em.persist(lance);
    }

    public Lance buscarLance(int id) {
        return em.find(Lance.class, id);
    }

    public List<Lance> listarTodosLances() {
        return em.createQuery("SELECT l FROM Lance l", Lance.class).getResultList();
    }

    @Transactional
    public void atualizarLance(Lance lance) {
        em.merge(lance);
    }

    @Transactional
    public void excluirLance(int id) {
        Lance lance = buscarLance(id);
        if (lance != null) {
            em.remove(lance);
        }
    }
}
