package naiarasantos.com.Controller;

import naiarasantos.com.Dto.BancoDto;
import naiarasantos.com.Entity.Banco;
import naiarasantos.com.Service.BancoService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("/bancos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BancoController {

    @Inject
    BancoService bancoService;

    @POST
    @Transactional
    public Response createBanco(BancoDto bancoDto) {
        Banco banco = new Banco(bancoDto.getIdBanco(), bancoDto.getNomeBanco(), 
        bancoDto.getCnpjBanco(), bancoDto.getCodigoBanco());
        bancoService.createBanco(banco);
        return Response.status(Response.Status.CREATED).entity(banco.bancoDto()).build();
    }

    @GET
    public List<BancoDto> findAll() {
        return bancoService.findAll().stream()
                .map(Banco::bancoDto)
                .collect(Collectors.toList());
    }

    @GET
    @Path("/{idBanco}")
    public Response findByIdBanco(@PathParam("idBanco") int idBanco) {
        Banco banco = bancoService.findByIdBanco(idBanco);
        if (banco == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(banco.bancoDto()).build();
    }

    @PUT
    @Path("/{idBanco}")
    @Transactional
    public Response updateBanco(@PathParam("idBanco") int idBanco, BancoDto bancoDto) {
        Banco banco = new Banco(idBanco, bancoDto.getNomeBanco(), bancoDto.getCnpjBanco(), 
        bancoDto.getCodigoBanco());
        Banco updatedBanco = bancoService.updateBanco(banco);
        if (updatedBanco == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(updatedBanco.bancoDto()).build();
    }

    @DELETE
    @Path("/{idBanco}")
    @Transactional
    public Response deleteBanco(@PathParam("idBanco") int idBanco) {
        bancoService.deleteBanco(idBanco);
        return Response.noContent().build();
    }

    @GET
    @Path("/cnpj/{cnpj}")
    public Response findByCnpj(@PathParam("cnpj") String cnpj) {
        Banco banco = bancoService.findByCnpj(cnpj);
        if (banco == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(banco.bancoDto()).build();
    }
}
