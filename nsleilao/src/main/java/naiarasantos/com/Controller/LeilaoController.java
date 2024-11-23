package naiarasantos.com.Controller;

import naiarasantos.com.Dto.LeilaoDto;
import naiarasantos.com.Entity.Leilao;
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
    public Response criarLeilao(Leilao leilao) {
        leilaoService.cadastrarLeilao(leilao);
        return Response.status(Response.Status.CREATED).entity(leilao).build();
    }

    @GET
    @Path("/{idLeilao}")
    public Response buscarLeilao(@PathParam("idLeilao") Integer idLeilao) {
        Leilao leilao = leilaoService.buscarLeilao(idLeilao);
        if (leilao == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(leilao).build();
    }

    @GET
    public List<Leilao> listarTodosLeiloes() {
        return leilaoService.listarTodosLeiloes();
    }

    @GET
    public List<Leilao> BuscarLeilaoDataInicial() {
        return leilaoService.BuscarLeilaoDataInicial();
    }

    @PUT
    @Path("/{idLeilao}")
    public Response atualizarLeilao(@PathParam("idLeilao") Integer idLeilao, LeilaoDto leilaoDto) {
        LeilaoDto leilaoAtualizado = leilaoService.atualizarLeilao(idLeilao, leilaoDto);
        if (leilaoAtualizado == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(leilaoAtualizado).build();
    }

    @DELETE
    @Path("/{idLeilao}")
    public Response excluirLeilao(@PathParam("idLeilao") Integer idLeilao) {
        boolean excluido = leilaoService.excluirLeilao(idLeilao);
        if (!excluido) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}
