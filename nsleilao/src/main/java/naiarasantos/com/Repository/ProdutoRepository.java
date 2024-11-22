package naiarasantos.com.Repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import naiarasantos.com.Dto.ProdutoDto;


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
        return em.createQuery("SELECT p FROM Produto p where p.idProduto = : idpProduto", ProdutoDto.class)
        .setParameter("idProduto", idProduto).getSingleResult();
    } 
}
    