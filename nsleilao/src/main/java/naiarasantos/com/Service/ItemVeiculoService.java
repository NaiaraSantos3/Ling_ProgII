package naiarasantos.com.Service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import naiarasantos.com.Entity.ItemVeiculo;
import naiarasantos.com.Repository.ItemVeiculoRepository;
import naiarasantos.com.Dto.ItemVeiculoDto;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ItemVeiculoService {

    @Inject
    ItemVeiculoRepository itemVeiculoRepository;

    public List<ItemVeiculo> listarTodos() {
        return itemVeiculoRepository.listAll();
    }

    public Optional<ItemVeiculo> buscarPorId(int id) {
        return itemVeiculoRepository.findByIdOptional(id);
    }

    public ItemVeiculo salvar(ItemVeiculo itemVeiculo) {
        itemVeiculoRepository.persist(itemVeiculo);
        return itemVeiculo;
    }

    public boolean atualizar(int id, ItemVeiculo itemAtualizado) {
        Optional<ItemVeiculo> itemVeiculoOpt = itemVeiculoRepository.findByIdOptional(id);
        if (itemVeiculoOpt.isPresent()) {
            ItemVeiculo itemExistente = itemVeiculoOpt.get();
            itemExistente.setModeloVeiculo(itemAtualizado.getModeloVeiculo());
            itemExistente.setFabricanteVeiculo(itemAtualizado.getFabricanteVeiculo());
            itemExistente.setAnoVeiculo(itemAtualizado.getAnoVeiculo());
            itemExistente.setPlacaVeiculo(itemAtualizado.getPlacaVeiculo());
            itemExistente.setChassi(itemAtualizado.getChassi());
            itemVeiculoRepository.persist(itemExistente);
            return true;
        }
        return false;
    }

    public boolean deletar(int id) {
        return itemVeiculoRepository.deleteById(id);
    }

    public ItemVeiculoDto converterParaDto(ItemVeiculo itemVeiculo) {
        return itemVeiculo.toItemVeiculoDto();
    }
}
