package naiarasantos.com.Service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import naiarasantos.com.Dto.ClienteDto;
import naiarasantos.com.Entity.Cliente;
import naiarasantos.com.Repository.ClienteRepository;

import java.util.List;

@ApplicationScoped
public class ClienteService {

    @Inject
    ClienteRepository clienteRepository;

    public List<Cliente> listarTodos() {
        return clienteRepository.listAll();
    }

    public Cliente buscarPorCpf(String cpf) {
        List<Cliente> clientes = clienteRepository.findByCpf(cpf);
        return clientes.isEmpty() ? null : clientes.get(0);  
    }

    @Transactional
    public void adicionarCliente(ClienteDto clienteDto) {
        Cliente cliente = new Cliente();
        cliente.setCpf(clienteDto.getCpf());
        cliente.setNomeCliente(clienteDto.getNomeCliente());
        cliente.setDataNascimentoCliente(clienteDto.getDataNascimentoCliente());
        cliente.setLance(clienteDto.getLance());

        clienteRepository.persist(cliente);
    }

    @Transactional
    public void atualizarCliente(String cpf, ClienteDto clienteDto) {
        Cliente cliente = buscarPorCpf(cpf);
        if (cliente != null) {
            cliente.setNomeCliente(clienteDto.getNomeCliente());
            cliente.setDataNascimentoCliente(clienteDto.getDataNascimentoCliente());
            cliente.setLance(clienteDto.getLance());
        }
    }

    @Transactional
    public void removerCliente(String cpf) {
        Cliente cliente = buscarPorCpf(cpf);
        if (cliente != null) {
            clienteRepository.delete(cliente);
        }
    }
}
