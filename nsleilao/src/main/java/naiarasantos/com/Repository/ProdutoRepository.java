package naiarasantos.com.Repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import naiarasantos.com.Dto.ProdutoDto;
import naiarasantos.com.Entity.Produto;


@ApplicationScoped
public class ProdutoRepository {
    @Inject
    @PersistenceContext
    EntityManager em;

    public List<ProdutoDto> ExibeProdutos() {
        return em.createQuery("SELECT p FROM Produto p",
                ProdutoDto.class).getResultList();
    }

    public ProdutoDto buscarProdutoPorId(Integer idProduto){
        return em.createQuery("SELECT p FROM Produto p where p.idProduto = : idProduto", ProdutoDto.class)
                .setParameter("idProduto", idProduto)
                .getSingleResult();
    }

    public Produto buscarProdutoPorIdLeilao(long idLeilao, long idProduto) {
        String query = "SELECT p FROM Produto p WHERE p.idProduto = :idProduto AND p.leilao.idLeilao = :idLeilao";
        return em.createQuery(query, Produto.class)
                .setParameter("idLeilao", idLeilao)
                .setParameter("idProduto", idProduto)
                .getSingleResult();
    }


}
    