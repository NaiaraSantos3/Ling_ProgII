package naiarasantos.com.Service;

import naiarasantos.com.Dto.LanceDto;
import naiarasantos.com.Entity.Lance;
import naiarasantos.com.Repository.LanceRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class LanceService {

    @Inject
    EntityManager em;

    @Inject
    LanceRepository lanceRepository;

    @Inject
    ClienteService clienteService;

    @Inject
    LeilaoService leilaoService;

    @Inject
    ProdutoService produtoService;

    // Cadastrar lance
    @Transactional
    public void cadastrarLance(LanceDto lanceDto) {
        // Converte o DTO para o objeto Lance
        Lance lance = fromDto(lanceDto);
        em.persist(lance);  // Persistir o objeto Lance
    }

    // Buscar lance por ID
    public LanceDto buscarLance(Integer idLance) {
        Lance lance = lanceRepository.findById(idLance);
        return lance != null ? toDto(lance) : null;
    }

    // Listar todos os lances
    public List<LanceDto> listarTodosLances() {
        return lanceRepository.listAll().stream()  // Usa o método correto listAll()
                .map(this::toDto)  // Converte Lance para LanceDto
                .collect(Collectors.toList());
    }

    // Atualizar lance
    @Transactional
    public LanceDto atualizarLance(Integer idLance, LanceDto lanceDto) {
        Lance lanceExistente = lanceRepository.findById(idLance);
        if (lanceExistente != null) {
            // Atualiza os campos do lance
            lanceExistente.setValorLance(lanceDto.getValorLance());
            lanceExistente.setDataHoraLance(lanceDto.getDataHoraLance());
            // Atualiza outros campos conforme necessário
            em.merge(lanceExistente);  // Atualiza o objeto no banco
            return toDto(lanceExistente);
        }
        throw new IllegalArgumentException("Este lance não existe");
    }

    // Excluir lance
    @Transactional
    public boolean excluirLance(Integer idLance) {
        Lance lance = lanceRepository.findById(idLance);
        if (lance != null) {
            em.remove(lance);  // Remove o objeto Lance
            return true;
        }
        throw new IllegalArgumentException("Este lance não existe");
    }

    // Converter Lance para LanceDto
    private LanceDto toDto(Lance lance) {
        return new LanceDto(
                lance.getIdLance(),
                lance.getValorLance(),
                lance.getDataHoraLance(),
                lance.getCliente().getIdCliente(),
                lance.getLeilao().getLeilao(),
                lance.getProduto().getIdProduto()
        );
    }

    // Converter LanceDto para Lance
    private Lance fromDto(LanceDto lanceDto) {
        // Assume que o Cliente, Leilao, e Produto já existem e são obtidos
        // Você pode querer adicionar validações se esses objetos não forem encontrados
        return new Lance(
                lanceDto.getIdLance(),
                lanceDto.getValorLance(),
                lanceDto.getDataHoraLance(),
                lanceDto.getCpfCliente(),  // A busca do Cliente
                lanceDto.getIdLeilao(),  // A busca do Leilao
                lanceDto.getIdProduto()  // A busca do Produto
        );
    }
}
