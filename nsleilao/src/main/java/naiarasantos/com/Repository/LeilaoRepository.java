package naiarasantos.com.Repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import java.util.List;

import naiarasantos.com.Dto.DetalhesLeilaoDTO;
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

    public DetalhesLeilaoDTO detalhesLeilaoDTO(Integer idLeilao) {
        String query = "SELECT l.idLeilao, l.dataAberturaLeilao, l.dataEncerramentoLeilao, l.dataVisitaProduto, l.siteLeilao, l.enderecoFisicoLeilao, l.cidadeLeilao, l.estadoLeilao, " +
                "COUNT(p.idProduto), b.nomeBanco FROM Leilao l LEFT JOIN l.banco b LEFT JOIN l.produto p WHERE l.idLeilao = :idLeilao GROUP BY l.idLeilao, l.dataAberturaLeilao, l.dataEncerramentoLeilao, " +
                "l.dataVisitaProduto, l.siteLeilao, l.enderecoFisicoLeilao, " +
                "l.cidadeLeilao, l.estadoLeilao, b.nomeBanco order by p.nomeProduto";

        return em.createQuery(query, DetalhesLeilaoDTO.class)
                .setParameter("idLeilao", idLeilao)
                .getSingleResult();
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


//
//private Integer idLeilao;
//private LocalDate dataAberturaLeilao;
//private LocalDate dataEncerramentoLeilao;
//private LocalDate dataVisitaProduto;
//private String siteLeilao;
//private String enderecoFisicoLeilao;
//private String cidadeLeilao;
//private String estadoLeilao;
