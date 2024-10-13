package naiarasantos.com.Repository;

import java.util.Optional;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import naiarasantos.com.Entity.ItemVeiculo;

@ApplicationScoped
public class ItemVeiculoRepository implements PanacheRepository<ItemVeiculo> {

    public Optional<ItemVeiculo> findByIdOptional(int id) {
        throw new UnsupportedOperationException("Método'findByIdOptional' não implementado");
    }

    public boolean deleteById(int id) {

        throw new UnsupportedOperationException("Método'deleteById' não implementado");
    }
}
