package naiarasantos.com.Controller;

import naiarasantos.com.Dto.ProdutoDto;
import naiarasantos.com.Entity.Produto;
import naiarasantos.com.Repository.ProdutoRepository;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("/produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoController {

    @Inject
    ProdutoRepository produtoRepository;

    @POST
    @Transactional
    public Response cadastrarProduto(ProdutoDto produtoDto) {
        Produto produto = new Produto(
            produtoDto.getNomeProduto(),
            produtoDto.getDescricaoProduto(),
            produtoDto.getValorInicialProduto()
        );
        produtoRepository.cadastrarProduto(produto);
        return Response.status(Response.Status.CREATED).entity(produto.toProdutoDto()).build();
    }

    @GET
    @Path("/{idProduto}")
    public Response buscarProduto(@PathParam("idProduto") int idProduto) {
        Produto produto = produtoRepository.BuscaProduto(idProduto);
        if (produto == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(produto.toProdutoDto()).build();
    }

    @GET
    public Response exibirProdutos() {
        List<Produto> produtos = produtoRepository.ExibeProdutos(); 
        List<ProdutoDto> produtoDtos = produtos.stream()
                                               .map(Produto::toProdutoDto)
                                               .collect(Collectors.toList());
        return Response.ok(produtoDtos).build();  
    }

    @PUT
    @Path("/{idProduto}")
    @Transactional
    public Response atualizarProduto(@PathParam("idProduto") int idProduto, ProdutoDto produtoDto) {
        Produto produtoExistente = produtoRepository.BuscaProduto(idProduto);
        if (produtoExistente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        produtoExistente.setNomeProduto(produtoDto.getNomeProduto());
        produtoExistente.setDescricaoProduto(produtoDto.getDescricaoProduto());
        produtoExistente.setValorInicialProduto(produtoDto.getValorInicialProduto());

        produtoRepository.atualizarProduto(produtoExistente);
        return Response.ok(produtoExistente.toProdutoDto()).build();
    }

    @DELETE
    @Path("/{idProduto}")
    @Transactional
    public Response excluirProduto(@PathParam("idProduto") int idProduto) {
        Produto produto = produtoRepository.BuscaProduto(idProduto);
        if (produto == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        produtoRepository.Excluir(idProduto);
        return Response.noContent().build();
    }
}
