package naiarasantos.com.Repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import naiarasantos.com.Entity.Banco;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BancoRepository implements PanacheRepository<Banco> {
    // Aqui você pode adicionar métodos customizados se necessário.

    // Exemplo de método customizado para encontrar um banco pelo CNPJ
    public Banco findByCnpj(String cnpj) {
        return find("cnpjBanco", cnpj).firstResult();
    }

    public Banco findByIdBanco(int idBanco) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByIdBanco'");
    }

    public void deleteByIdBanco(int idBanco) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteByIdBanco'");
    }
}
