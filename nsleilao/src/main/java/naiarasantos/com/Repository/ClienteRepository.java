package naiarasantos.com.Repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import naiarasantos.com.Entity.Cliente;
import java.util.List;

@ApplicationScoped
public class ClienteRepository implements PanacheRepository<Cliente> {
    
    public List<Cliente> findByCpf (String cpf) {
        return list("cpf", cpf);  // Certifique-se que o nome do campo no banco de dados é 'cpf'
    }
}
