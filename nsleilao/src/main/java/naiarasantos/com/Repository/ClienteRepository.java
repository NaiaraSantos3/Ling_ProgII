package naiarasantos.com.Repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import naiarasantos.com.Entity.Cliente;
import java.util.List;

@ApplicationScoped
public class ClienteRepository {

    @Inject
    EntityManager em;

    // Buscar cliente por CPF
    public Cliente findByCpf(String cpf) {
        return em.createQuery("select c from Cliente c where c.cpf = :cpf", Cliente.class)
                .setParameter("cpf", cpf)
                .getSingleResult();
    }

    // Buscar cliente por ID
    public Cliente findByIdCliente(Integer idCliente) {
        return em.createQuery("select c from Cliente c where c.idCliente = :idCliente", Cliente.class)
                .setParameter("idCliente", idCliente)
                .getSingleResult();
    }

    // Listar todos os clientes
    public List<Cliente> listAll() {
        return em.createQuery("select c from Cliente c", Cliente.class)
                .getResultList();
    }

    // Persistir cliente
    public void persist(Cliente cliente) {
        em.persist(cliente);
    }

    // Atualizar cliente
    public Cliente merge(Cliente cliente) {
        return em.merge(cliente);
    }

    // Remover cliente
    public void remove(Cliente cliente) {
        em.remove(cliente);
    }
}
