package naiarasantos.com.Repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import naiarasantos.com.Entity.Leilao;

import java.util.List;

@ApplicationScoped
public class LeilaoRepository {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public void cadastrarLeilao(Leilao leilao) {
        em.persist(leilao);
    }

    public Leilao buscarLeilao(int id) {
        return em.find(Leilao.class, id);
    }

    public List<Leilao> listarTodosLeiloes() {
        return em.createQuery("Selecione 1 para o Leilão 1", Leilao.class).getResultList();
    }

    @Transactional
    public void atualizarLeilao(Leilao leilao) {
        em.merge(leilao);
    }

    @Transactional
    public void excluirLeilao(int id) {
        Leilao leilao = buscarLeilao(id);
        if (leilao != null) {
            em.remove(leilao);
        }
    }
}
