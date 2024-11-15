package naiarasantos.com.Repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import naiarasantos.com.Entity.Lance;
import naiarasantos.com.Entity.Produto;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class LanceRepository implements PanacheRepository<Lance> {
        @PersistenceContext
        EntityManager em;
    public Lance findByIdLance(Integer idLance) {
        return find("idLance", idLance).firstResult();
    }

    public Lance findByProdutoLance(Produto produto) {
        return find("produto", produto).firstResult();
    }

    public List<Lance> ExibeLance(){
        return em.createQuery("SELECT l FROM Lance l", Lance.class).getResultList();

    }

}