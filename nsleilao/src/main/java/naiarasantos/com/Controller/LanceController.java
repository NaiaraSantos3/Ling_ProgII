package naiarasantos.com.Controller;

import naiarasantos.com.Dto.LanceDto;
import naiarasantos.com.Service.LanceService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/lances")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LanceController {

    @Inject
    LanceService lanceService;

    @POST
    public Response cadastrarLance(LanceDto lanceDto) {
        try {
            lanceService.cadastrarLance(lanceDto);
            return Response.status(Response.Status.CREATED).entity(lanceDto).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/{id}")
    public Response buscarLance(@PathParam("id") int id) {
        LanceDto lance = lanceService.buscarLance(id);
        if (lance == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(lance).build();
    }

    @GET
    public List<LanceDto> listarTodosLances() {
        return lanceService.listarTodosLances();
    }

    @PUT
    @Path("/{id}")
    public Response atualizarLance(@PathParam("id") int id, LanceDto lanceDto) {
        LanceDto lanceAtualizado = lanceService.atualizarLance(id, lanceDto);
        if (lanceAtualizado == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(lanceAtualizado).build();
    }

    @DELETE
    @Path("/{id}")
    public Response excluirLance(@PathParam("id") int id) {
        boolean excluido = lanceService.excluirLance(id);
        if (!excluido) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}
