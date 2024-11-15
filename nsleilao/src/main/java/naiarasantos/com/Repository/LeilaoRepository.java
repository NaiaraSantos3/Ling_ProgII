package naiarasantos.com.Repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import naiarasantos.com.Entity.Leilao;


import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class LeilaoRepository implements PanacheRepository<Leilao>{

    @PersistenceContext
    EntityManager em;

    public Leilao findByIdLeilao(Integer idLeilao) {
        return find("idLeilao", idLeilao).firstResult();
    }

}
