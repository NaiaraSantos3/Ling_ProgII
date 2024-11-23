package naiarasantos.com.Repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import java.util.List;
import naiarasantos.com.Entity.Leilao;

@ApplicationScoped
public class LeilaoRepository {

    @Inject
    EntityManager em;

    public void persist(Leilao leilao) {
        em.persist(leilao); // Persistência da entidade
    }

    public Leilao findByIdLeilao(Integer idLeilao) {
        try {
            return em.createQuery("SELECT l FROM Leilao l WHERE l.idLeilao = :idLeilao", Leilao.class)
                    .setParameter("idLeilao", idLeilao)
                    .getSingleResult();
        } catch (Exception e) {
            return null; // Retorna null caso não encontre
        }
    }

    public List<Leilao> listAll() {
        return em.createQuery("SELECT l FROM Leilao l", Leilao.class).getResultList();
    }
    //Buscar Leilão por ordem data de ocorrência
    public List<Leilao> listAllDataLeilao() {
        return em.createQuery( "SELECT l FROM Leilao l order by l.dataAberturaLeilao", Leilao.class).getResultList();
    }

    public void remove(Leilao leilao) {
        em.remove(em.contains(leilao) ? leilao : em.merge(leilao)); // Remove entidade
    }
}
