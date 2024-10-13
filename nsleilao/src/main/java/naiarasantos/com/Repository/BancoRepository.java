package naiarasantos.com.Repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import naiarasantos.com.Entity.Banco;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BancoRepository implements PanacheRepository<Banco> {

    public Banco findByCnpj(String cnpj) {
        return find("cnpjBanco", cnpj).firstResult();
    }

    public Banco findByIdBanco(int idBanco) {
        throw new UnsupportedOperationException("Método'findByIdBanco'não implementado");
    }

    public void deleteByIdBanco(int idBanco) {
        throw new UnsupportedOperationException("Método'deleteByIdBanco' não implementado");
    }
}
