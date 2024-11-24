package naiarasantos.com.Controller;

import naiarasantos.com.Dto.ProdutoDto;
import naiarasantos.com.Entity.Produto;
import naiarasantos.com.Service.ProdutoService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoController {

    @Inject
    ProdutoService produtoService;

    @POST
    @Transactional
    public Response cadastrarProduto(Produto produto) {
        
        return Response.status(Response.Status.CREATED).entity(produto.toProdutoDto()).build();
    }

    @GET
    @Path("ProdutoPorId/{idProduto}")
    public Response buscarProdutoPorId(@PathParam("idProduto") int idProduto) {
        ProdutoDto produto = produtoService.buscarProdutoPorId(idProduto);
        if (produto == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(produto).build();
    }

    @GET
    @Path("/produto/{idProduto}")
    public Response buscarProdutoPorIdLeilao(@PathParam("idLeilao") Long idLeilao,@PathParam("idProduto") Long idProduto) {
        Produto produto = produtoService.buscarProdutoPorIdLeilao(idLeilao, idProduto);
        if (produto == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(produto.toProdutoDto()).build();
    }

    @GET
    public List<ProdutoDto> exibirProdutos() {
        return produtoService.listarTodosProdutos(); 
   
    }

    @PUT
    @Path("/{idProduto}")
    @Transactional
    public Response atualizarProduto(@PathParam("idProduto") Integer idProduto, ProdutoDto produtoDto) {
        ProdutoDto produtoExistente = produtoService.buscarProdutoPorId(idProduto);
        if (produtoExistente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        produtoService.atualizarProduto(idProduto, produtoExistente);
        return Response.ok(produtoExistente).build();
    }

    @DELETE
    @Path("/{idProduto}")
    @Transactional
    public Response excluirProduto(@PathParam("idProduto") int idProduto) {
        ProdutoDto produto = produtoService.buscarProdutoPorId(idProduto);
        if (produto == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        produtoService.excluirProduto(idProduto);
        return Response.noContent().build();
    }
}
