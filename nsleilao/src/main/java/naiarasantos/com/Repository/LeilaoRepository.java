package naiarasantos.com.Repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import java.util.List;

import naiarasantos.com.Dto.DetalhesLeilaoDTO;
import naiarasantos.com.Entity.Leilao;
import naiarasantos.com.Entity.Produto;

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

    public DetalhesLeilaoDTO detalhesLeilaoDTO(Integer idLeilao) {
        String produtoQuery = "SELECT p.nomeProduto FROM Produto p WHERE p.leilao = :idLeilao";
        List<String> produto = em.createQuery(produtoQuery, String.class)
                .setParameter("idLeilao", idLeilao)
                .getResultList();

        String bancosQuery = "SELECT b.nomeBanco FROM Banco b WHERE b.leilao = :idLeilao";
        List<String> banco = em.createQuery(bancosQuery, String.class)
                .setParameter("idLeilao", idLeilao)
                .getResultList();

        String leilaoQuery = "SELECT l FROM Leilao l WHERE l.idLeilao = :idLeilao";
        Leilao leilao = em.createQuery(leilaoQuery, Leilao.class)
                .setParameter("idLeilao", idLeilao)
                .getSingleResult();

        String countQuery = "SELECT COUNT(p.id) FROM Produto p WHERE p.leilao = :idLeilao";
        Long quantidadeDeProdutos = em.createQuery(countQuery, Long.class)
                .setParameter("idLeilao", idLeilao)
                .getSingleResult();
        return new DetalhesLeilaoDTO(produto, banco, leilao, quantidadeDeProdutos.intValue());
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

