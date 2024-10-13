package naiarasantos.com.Service;

import naiarasantos.com.Dto.LanceDto;
import naiarasantos.com.Entity.Cliente;
import naiarasantos.com.Entity.Lance;
import naiarasantos.com.Entity.Leilao;
import naiarasantos.com.Entity.Produto;
import naiarasantos.com.Repository.LanceRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class LanceService {

    @Inject
    LanceRepository lanceRepository;

    @Inject
    ClienteService clienteService;  
    @Inject
    LeilaoService leilaoService;    
    @Inject
    ProdutoService produtoService;  

    @Transactional
    public LanceDto cadastrarLance(LanceDto lanceDto) {
        Cliente cliente = clienteService.buscarPorCpf(lanceDto.getCpfCliente());
        Leilao leilao = leilaoService.buscarLeilaoPorId(lanceDto.getIdLeilao());  
        Produto produto = produtoService.buscarProdutoPorId(lanceDto.getIdProduto());  

        if (cliente == null || leilao == null || produto == null) {
            throw new IllegalArgumentException("Cliente, Leilão ou Produto inválido");
        }

        Lance lance = new Lance(
            0, lanceDto.getValorLance(),
            lanceDto.getDataHoraLance(),
            cliente,
            leilao,
            produto
        );

        lanceRepository.cadastrarLance(lance);
        return toDto(lance);
    }

    public LanceDto buscarLance(int id) {
        Lance lance = lanceRepository.buscarLance(id);
        return lance != null ? toDto(lance) : null;
    }

    public List<LanceDto> listarTodosLances() {
        return lanceRepository.listarTodosLances().stream()
            .map(this::toDto)
            .collect(Collectors.toList());
    }

    @Transactional
    public LanceDto atualizarLance(int id, LanceDto lanceDto) {
        Lance lanceExistente = lanceRepository.buscarLance(id);
        if (lanceExistente == null) {
            return null;
        }

        lanceExistente.setValorLance(lanceDto.getValorLance());
        lanceExistente.setDataHoraLance(lanceDto.getDataHoraLance());

        lanceRepository.atualizarLance(lanceExistente);
        return toDto(lanceExistente);
    }

    @Transactional
    public boolean excluirLance(int id) {
        Lance lance = lanceRepository.buscarLance(id);
        if (lance == null) {
            return false;
        }

        lanceRepository.excluirLance(id);
        return true;
    }

    private LanceDto toDto(Lance lance) {
        return new LanceDto(
            lance.getIdLance(),
            lance.getValorLance(),
            lance.getDataHoraLance(),
            lance.getCliente().getCpf(),    
            lance.getLeilao().getIdLeilao(),
            lance.getProduto().getIdProduto()
        );
    }
}
