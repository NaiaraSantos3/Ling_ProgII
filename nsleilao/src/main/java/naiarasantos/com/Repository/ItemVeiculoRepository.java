package naiarasantos.com.Repository;

import java.util.Optional;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import naiarasantos.com.Entity.ItemVeiculo;

@ApplicationScoped
public class ItemVeiculoRepository implements PanacheRepository<ItemVeiculo> {

    public Optional<ItemVeiculo> findByIdOptional(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByIdOptional'");
    }
    // Métodos adicionais de consulta podem ser implementados aqui, se necessário

    public boolean deleteById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }
}
