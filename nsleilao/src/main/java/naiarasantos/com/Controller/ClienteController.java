package naiarasantos.com.Controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import naiarasantos.com.Dto.ClienteDto;
import naiarasantos.com.Entity.Cliente;
import naiarasantos.com.Service.ClienteService;

import java.util.List;

@Path("/clientes")  
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteController {

    @Inject
    ClienteService clienteService;

    @GET
    public List<Cliente> listarTodos() {
        return clienteService.listarTodos();
    }

    @GET
    @Path("/{cpf}")
    public Response buscarPorCpf(@PathParam("cpf") String cpf) {
        Cliente cliente = clienteService.buscarPorCpf(cpf);
        if (cliente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();  
            //Retorna o erro 404 se não encontrado
        }
        return Response.ok(cliente).build();  // Retorna o cliente encontrado
    }

    @POST
    public Response adicionarCliente(ClienteDto clienteDto) {
        clienteService.adicionarCliente(clienteDto);
        return Response.status(Response.Status.CREATED).build();  // Retorna o erro 201 após a criação
    }

    @PUT
    @Path("/{cpf}")
    public Response atualizarCliente(@PathParam("cpf") String cpf, ClienteDto clienteDto) {
        clienteService.atualizarCliente(cpf, clienteDto);
        return Response.noContent().build();  // Retorna o erro 204 após a atualização
    }

    @DELETE
    @Path("/{cpf}")
    public Response removerCliente(@PathParam("cpf") String cpf) {
        clienteService.removerCliente(cpf);
        return Response.noContent().build();  //Retorna o erro 204 após a remoção
    }
}
