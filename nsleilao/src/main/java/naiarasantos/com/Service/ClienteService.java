package naiarasantos.com.Service;

import jakarta.persistence.EntityManager;
import naiarasantos.com.Dto.ClienteDto;
import naiarasantos.com.Entity.Cliente;
import naiarasantos.com.Repository.ClienteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@ApplicationScoped
public class ClienteService {

    @Inject
    ClienteRepository clienteRepository;

    @Inject
    EntityManager em;

    // Criar cliente
    @Transactional
    public void createCliente(ClienteDto clienteDto) {
        em.persist(clienteDto);
    }

    // Listar todos os clientes
    public List<Cliente> findAll() {
        return clienteRepository.listAll(); // Usando listAll do repositório
    }

    // Buscar cliente por CPF
    public Cliente findByCpf(String cpf) {
        return clienteRepository.findByCpf(cpf); // Busca cliente pelo CPF
    }

    // Atualizar cliente
    @Transactional
    public ClienteDto updateCliente(ClienteDto clienteDto) {
        Cliente clienteExistente = clienteRepository.findByCpf(clienteDto.getCpf()); // Busca pelo CPF
        if (clienteExistente == null) {
            return null; // Se não existir, retorna null
        }
        return em.merge(clienteDto); // Usando merge do repositório para atualizar
    }

    // Deletar cliente
    @Transactional
    public boolean deleteCliente(String cpf) {
        Cliente cliente = clienteRepository.findByCpf(cpf); // Busca o cliente pelo CPF
        if (cliente != null) {
            em.remove(cliente); // Removendo o cliente usando o repositório
            return true;
        }
        return false;
    }
}
