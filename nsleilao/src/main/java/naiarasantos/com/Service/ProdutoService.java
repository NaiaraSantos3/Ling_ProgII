package naiarasantos.com.Service;

import naiarasantos.com.Dto.ProdutoDto;
import naiarasantos.com.Entity.Produto;
import naiarasantos.com.Repository.ProdutoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ProdutoService {
    
    @Inject
    EntityManager em;

    @Inject
    ProdutoRepository produtoRepository;

    @Transactional
    public void cadastrarProduto (ProdutoDto produtodDto) {
        em.persist(produtodDto);
    }

    public ProdutoDto buscarProdutoPorId(Integer idProduto) {
        return produtoRepository.buscarProdutoPorId(idProduto);

    }

    public Produto buscarProdutoPorIdLeilao(Long idLeilao, Long idProduto) {
        return produtoRepository.buscarProdutoPorIdLeilao(idLeilao, idProduto);
    }

    public List<ProdutoDto> listarTodosProdutos() {
       return produtoRepository.ExibeProdutos(); 
    }

    @Transactional
    public ProdutoDto atualizarProduto(Integer idProduto, ProdutoDto produtoDto) {
        if(buscarProdutoPorId(idProduto) != null){
            em.merge(produtoDto);
            return produtoDto;
        }
        throw new IllegalArgumentException("Este produto não existe");
    }

    @Transactional
    public boolean excluirProduto(Integer idProduto) {
        if(buscarProdutoPorId(idProduto) != null){
            em.remove(idProduto);
            return true;
            
        }
        throw new IllegalArgumentException("Este produto não existe");
    }

}
