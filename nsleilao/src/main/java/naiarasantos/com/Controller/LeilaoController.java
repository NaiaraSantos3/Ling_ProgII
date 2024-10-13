package naiarasantos.com.Controller;

import naiarasantos.com.Dto.LeilaoDto;
import naiarasantos.com.Service.LeilaoService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/leiloes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LeilaoController {

    @Inject
    LeilaoService leilaoService;

    @POST
    public Response cadastrarLeilao(LeilaoDto leilaoDto) {
        LeilaoDto novoLeilao = leilaoService.cadastrarLeilao(leilaoDto);
        return Response.status(Response.Status.CREATED).entity(novoLeilao).build();
    }

    @GET
    @Path("/{id}")
    public Response buscarLeilao(@PathParam("id") int id) {
        LeilaoDto leilao = leilaoService.buscarLeilao(id);
        if (leilao == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(leilao).build();
    }

    @GET
    public List<LeilaoDto> listarTodosLeiloes() {
        return leilaoService.listarTodosLeiloes();
    }

    @PUT
    @Path("/{id}")
    public Response atualizarLeilao(@PathParam("id") int id, LeilaoDto leilaoDto) {
        LeilaoDto leilaoAtualizado = leilaoService.atualizarLeilao(id, leilaoDto);
        if (leilaoAtualizado == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(leilaoAtualizado).build();
    }

    @DELETE
    @Path("/{id}")
    public Response excluirLeilao(@PathParam("id") int id) {
        boolean excluido = leilaoService.excluirLeilao(id);
        if (!excluido) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}
