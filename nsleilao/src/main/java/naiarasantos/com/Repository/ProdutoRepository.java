package naiarasantos.com.Repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import naiarasantos.com.Entity.Produto;

@ApplicationScoped
public class ProdutoRepository {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public void CadastraProduto(Produto produto) {
        em.persist(produto);
    }

    public Produto BuscaProduto(int id) {
        return em.find(Produto.class, id);
    }

    public List<Produto> ExibeProdutos() {
        return em.createQuery("SELECT p FROM Produto p", 
        Produto.class).getResultList();
    }

    @Transactional
    public void atualizar(Produto produto) {
        em.merge(produto); 
    }

    @Transactional
    public void Excluir(int id) {
        Produto produto = BuscaProduto(id);
        if (produto != null) {
            em.remove(produto);
        }
    }

    public void cadastrarProduto(Produto produto) {
        throw new UnsupportedOperationException("Método'cadastrarProduto' não implementado");
    }

    public void atualizarProduto(Produto produtoExistente) {
        throw new UnsupportedOperationException("Méthodo'atualizarProduto' não implementado");
    }
}
