package naiarasantos.com.Service;

import naiarasantos.com.Dto.LeilaoDto;
import naiarasantos.com.Entity.Leilao;
import naiarasantos.com.Repository.LeilaoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class LeilaoService {

    @Inject
    LeilaoRepository leilaoRepository;

    @Transactional
    public LeilaoDto cadastrarLeilao(Leilao leilao) {
        leilaoRepository.persist(leilao);
        return leilao.leilaoDto();
    }

    public Leilao buscarLeilao(Integer idLeilao) {
        Leilao leilao = leilaoRepository.findByIdLeilao(idLeilao);
        if (leilao == null) {
            throw new IllegalArgumentException("Leilão não encontrado para o ID: " + idLeilao);
        }
        return leilao;
    }

    public List<LeilaoDto> listarTodosLeiloes() {
        return leilaoRepository.listAll().stream()
                .map(Leilao::leilaoDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public LeilaoDto atualizarLeilao(Integer idLeilao, LeilaoDto leilaoDto) {
        Leilao leilaoExistente = leilaoRepository.findByIdLeilao(idLeilao);
        if (leilaoExistente == null) {
            throw new IllegalArgumentException("Leilão não encontrado para o ID: " + idLeilao);
        }

        // Atualiza os campos
        leilaoExistente.setDataAberturaLeilao(leilaoDto.getDataAberturaLeilao());
        leilaoExistente.setDataEncerramentoLeilao(leilaoDto.getDataEncerramentoLeilao());
        leilaoExistente.setDataVisitaProduto(leilaoDto.getDataVisitaProduto());
        leilaoExistente.setSiteLeilao(leilaoDto.getSiteLeilao());
        leilaoExistente.setEnderecoFisicoLeilao(leilaoDto.getEnderecoFisicoLeilao());
        leilaoExistente.setCidadeLeilao(leilaoDto.getCidadeLeilao());
        leilaoExistente.setEstadoLeilao(leilaoDto.getEstadoLeilao());
        leilaoRepository.persist(leilaoExistente);
        return leilaoExistente.leilaoDto();
    }

    @Transactional
    public boolean excluirLeilao(Integer idLeilao) {
        Leilao leilao = buscarLeilao(idLeilao);
        if (leilao != null) {
            leilaoRepository.remove(leilao);
            return true;
        }
        throw new IllegalArgumentException("Leilão não encontrado para o ID: " + idLeilao);
    }
}
