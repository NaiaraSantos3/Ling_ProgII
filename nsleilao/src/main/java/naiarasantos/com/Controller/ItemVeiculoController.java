package naiarasantos.com.Controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import naiarasantos.com.Entity.ItemVeiculo;
import naiarasantos.com.Service.ItemVeiculoService;
import java.util.List;
import java.util.Optional;

@Path("/itemveiculos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ItemVeiculoController {

    @Inject
    ItemVeiculoService itemVeiculoService;

    @GET
    public List<ItemVeiculo> listarTodos() {
        return itemVeiculoService.listarTodos();
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") int id) {
        Optional<ItemVeiculo> itemVeiculoOpt = itemVeiculoService.buscarPorId(id);
        return itemVeiculoOpt
            .map(item -> Response.ok(item).build())
            .orElseGet(() -> Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    public Response criarItemVeiculo(ItemVeiculo itemVeiculo) {
        ItemVeiculo novoItem = itemVeiculoService.salvar(itemVeiculo);
        return Response.status(Response.Status.CREATED).entity(novoItem).build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizarItemVeiculo(@PathParam("id") int id, ItemVeiculo itemAtualizado) {
        boolean atualizado = itemVeiculoService.atualizar(id, itemAtualizado);
        if (atualizado) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deletarItemVeiculo(@PathParam("id") int id) {
        boolean deletado = itemVeiculoService.deletar(id);
        if (deletado) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
