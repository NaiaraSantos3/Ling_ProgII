package naiarasantos.com.Service;

import naiarasantos.com.Dto.ProdutoDto;
import naiarasantos.com.Entity.Produto;
import naiarasantos.com.Repository.ProdutoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ProdutoService {

    @Inject
    ProdutoRepository produtoRepository;

    @Transactional
    public ProdutoDto cadastrarProduto(ProdutoDto produtoDto) {
        Produto produto = new Produto(
            produtoDto.getNomeProduto(),
            produtoDto.getDescricaoProduto(),
            produtoDto.getValorInicialProduto()
        );
        produtoRepository.cadastrarProduto(produto);
        return produto.toProdutoDto();  // Corrigido para chamar o método correto
    }

    public ProdutoDto buscarProduto(int idProduto) {
        Produto produto = produtoRepository.BuscaProduto(idProduto);
        if (produto == null) {
            return null; 
        }
        return produto.toProdutoDto();  // Corrigido para chamar o método correto
    }

    public List<ProdutoDto> listarTodosProdutos() {
        List<Produto> produtos = produtoRepository.ExibeProdutos();  // Certifique-se de que o método é camelCase
        return produtos.stream()
                .map(Produto::toProdutoDto)  // Corrigido para usar o método correto
                .collect(Collectors.toList());
    }

    @Transactional
    public ProdutoDto atualizarProduto(int idProduto, ProdutoDto produtoDto) {
        Produto produtoExistente = produtoRepository.BuscaProduto(idProduto);
        if (produtoExistente == null) {
            return null; 
        }

        produtoExistente.setNomeProduto(produtoDto.getNomeProduto());
        produtoExistente.setDescricaoProduto(produtoDto.getDescricaoProduto());
        produtoExistente.setValorInicialProduto(produtoDto.getValorInicialProduto());

        produtoRepository.atualizar(produtoExistente);
        return produtoExistente.toProdutoDto();  // Corrigido para chamar o método correto
    }

    @Transactional
    public boolean excluirProduto(int idProduto) {
        Produto produto = produtoRepository.BuscaProduto(idProduto);
        if (produto == null) {
            return false; 
        }
        produtoRepository.Excluir(idProduto);  // Certifique-se de que o método excluir está correto
        return true; 
    }

    public Produto buscarProdutoPorId(int idProduto) {
        // Método ainda não implementado
        throw new UnsupportedOperationException("Unimplemented method 'buscarProdutoPorId'");
    }
}
