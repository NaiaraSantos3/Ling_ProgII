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

    @Transactional
    public void cadastrarLance(LanceDto lanceDto) {
        em.persist(lanceDto);
    }

    public LanceDto buscarLance(Integer idLance) {
        Lance lance = lanceRepository.findByIdLance(idLance);
        return lance != null ? toDto(lance) : null;
    }

    public List<LanceDto> listarTodosLances() {
        return lanceRepository.ExibeLance().stream()
            .map(this::toDto)
            .collect(Collectors.toList());
    }

    @Transactional
    public LanceDto atualizarLance(Integer idLance, LanceDto lanceDto) {
        if(buscarLance(idLance) != null){
            em.merge(lanceDto);
            return lanceDto;
        }
        throw new IllegalArgumentException("Este lance não existe");
    }

    @Transactional
    public boolean excluirLance(Integer idLance) {
        if(buscarLance(idLance) != null){
            em.remove(idLance);
            return true;
            
        }
        throw new IllegalArgumentException("Este lance não existe");
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
