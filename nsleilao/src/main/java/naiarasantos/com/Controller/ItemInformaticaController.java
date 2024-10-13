package naiarasantos.com.Controller;

import naiarasantos.com.Dto.ItemInformaticaDto;
import naiarasantos.com.Service.ItemInformaticaService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/itens-informatica")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ItemInformaticaController {

    @Inject
    ItemInformaticaService itemInformaticaService;

    @POST
    public Response cadastrarItem(ItemInformaticaDto itemDto) {
        ItemInformaticaDto novoItem = itemInformaticaService.cadastrarItem(itemDto);
        return Response.status(Response.Status.CREATED).entity(novoItem).build();
    }

    @GET
    @Path("/{id}")
    public Response buscarItem(@PathParam("id") int id) {
        ItemInformaticaDto item = (ItemInformaticaDto) itemInformaticaService.buscarItem(id);
        if (item == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(item).build();
    }

    @GET
    public List<ItemInformaticaDto> listarTodosItens() {
        return itemInformaticaService.listarTodosItens();
    }

    @PUT
    @Path("/{id}")
    public Response atualizarItem(@PathParam("id") int id, ItemInformaticaDto itemDto) {
        ItemInformaticaDto itemAtualizado = itemInformaticaService.atualizarItem(id, itemDto);
        if (itemAtualizado == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(itemAtualizado).build();
    }

    @DELETE
    @Path("/{id}")
    public Response excluirItem(@PathParam("id") int id) {
        boolean excluido = itemInformaticaService.excluirItem(id);
        if (!excluido) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}
