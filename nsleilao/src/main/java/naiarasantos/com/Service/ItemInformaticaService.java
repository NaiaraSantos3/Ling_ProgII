package naiarasantos.com.Service;

import naiarasantos.com.Dto.ItemInformaticaDto;
import naiarasantos.com.Entity.ItemInformatica;
import naiarasantos.com.Repository.ItemInformaticaRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ItemInformaticaService {

    @Inject
    ItemInformaticaRepository itemInformaticaRepository;

    @Transactional
    public ItemInformaticaDto cadastrarItem(ItemInformaticaDto itemDto) {

        ItemInformatica itemInformatica = new ItemInformatica(
            itemDto.getNomeProduto(),
            itemDto.getDescricaoProduto(),
            itemDto.getValorInicialProduto(),
            itemDto.getModeloInformatica(),
            itemDto.getMarcaInformatica(),
            itemDto.getNumeroSerie()
        );
        
        itemInformaticaRepository.cadastrarItem(itemInformatica);
        
        return itemInformatica.toItemInformaticatoDto();
    }

    public ItemInformaticaDto buscarItem(int id) {
        ItemInformatica item = itemInformaticaRepository.buscarItem(id);
        
        if (item == null) {
            return null; 
        }

        return item.toItemInformaticatoDto();
    }

    public List<ItemInformaticaDto> listarTodosItens() {
        List<ItemInformatica> itens = itemInformaticaRepository.listarTodosItens();
        
        return itens.stream()
                    .map(ItemInformatica::toItemInformaticatoDto)
                    .collect(Collectors.toList());
    }

    @Transactional
    public ItemInformaticaDto atualizarItem(int id, ItemInformaticaDto itemDto) {
        ItemInformatica itemExistente = itemInformaticaRepository.buscarItem(id);
        
        if (itemExistente == null) {
            return null; 
        }
        
        itemExistente.setNomeProduto(itemDto.getNomeProduto());
        itemExistente.setDescricaoProduto(itemDto.getDescricaoProduto());
        itemExistente.setValorInicialProduto(itemDto.getValorInicialProduto());
        itemExistente.setModeloInformatica(itemDto.getModeloInformatica());
        itemExistente.setMarcaInformatica(itemDto.getMarcaInformatica());
        itemExistente.setNumeroSerie(itemDto.getNumeroSerie());
        
        itemInformaticaRepository.atualizarItem(itemExistente);
        
        return itemExistente.toItemInformaticatoDto();
    }

    @Transactional
    public boolean excluirItem(int id) {
        ItemInformatica item = itemInformaticaRepository.buscarItem(id);
        
        if (item == null) {
            return false;
        }
        
        itemInformaticaRepository.excluirItem(id);
        return true;
    }
}
