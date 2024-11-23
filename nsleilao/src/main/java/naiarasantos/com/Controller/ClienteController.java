package naiarasantos.com.Controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import naiarasantos.com.Dto.ClienteDto;
import naiarasantos.com.Entity.Cliente;
import naiarasantos.com.Service.ClienteService;
import java.util.stream.Collectors;

import java.util.List;

@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteController {

    @Inject
    ClienteService clienteService;

    // Listar todos os clientes
    @GET
    public List<Cliente> listarTodos() {
        return clienteService.findAll();
    }

    // Buscar cliente por CPF
    @GET
    @Path("/{cpf}")
    public Response buscarPorCpf(@PathParam("cpf") String cpf) {
        Cliente cliente = clienteService.findByCpf(cpf);
        if (cliente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();  // Retorna 404 se não encontrado
        }
        return Response.ok(cliente).build();  // Retorna 200 com o cliente encontrado
    }

    // Adicionar novo cliente
    @POST
    public Response adicionarCliente(ClienteDto cliente) {
        clienteService.createCliente(cliente);  // Chama o serviço para adicionar o cliente
        return Response.status(Response.Status.CREATED).build();  // Retorna 201 após a criação
    }

    // Atualizar cliente
    @PUT
    @Path("/{cpf}")
    public Response atualizarCliente(@PathParam("cpf") String cpf, ClienteDto clienteDto) {
        Cliente clienteExistente = clienteService.findByCpf(cpf);
        if (clienteExistente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();  // Retorna 404 se não encontrado
        }
        ClienteDto novoCliente = clienteService.updateCliente(clienteDto);
        return Response.ok(clienteExistente).build();
    }

    // Remover cliente
    @DELETE
    @Path("/{cpf}")
    public Response removerCliente(@PathParam("cpf") String cpf) {
        boolean removed = clienteService.deleteCliente(cpf);
        if (!removed) {
            return Response.status(Response.Status.NOT_FOUND).build();  // Retorna 404 se não encontrado
        }
        return Response.noContent().build();  // Retorna 204 após a remoção
    }

}
