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
    public LeilaoDto cadastrarLeilao(LeilaoDto leilaoDto) {
        Leilao leilao = new Leilao(
            leilaoDto.getIdLeilao(),
            leilaoDto.getDataAberturaLeilao(),
            leilaoDto.getDataEncerramentoLeilao(),
            leilaoDto.getDataVisitaProduto(),
            leilaoDto.getSiteLeilao(),
            leilaoDto.getEnderecoFisicoLeilao(),
            leilaoDto.getCidadeLeilao(),
            leilaoDto.getEstadoLeilao(),
            leilaoDto.getStatusLeilao()
        );
        leilaoRepository.cadastrarLeilao(leilao);
        return leilao.leilaoDto();
    }

    public LeilaoDto buscarLeilao(int id) {
        Leilao leilao = leilaoRepository.buscarLeilao(id);
        if (leilao == null) {
            return null;
        }
        return leilao.leilaoDto();
    }

    public List<LeilaoDto> listarTodosLeiloes() {
        List<Leilao> leiloes = leilaoRepository.listarTodosLeiloes();
        return leiloes.stream().map(Leilao::leilaoDto).collect(Collectors.toList());
    }

    @Transactional
    public LeilaoDto atualizarLeilao(int id, LeilaoDto leilaoDto) {
        Leilao leilaoExistente = leilaoRepository.buscarLeilao(id);
        if (leilaoExistente == null) {
            return null;
        }

        leilaoExistente.setDataAberturaLeilao(leilaoDto.getDataAberturaLeilao());
        leilaoExistente.setDataEncerramentoLeilao(leilaoDto.getDataEncerramentoLeilao());
        leilaoExistente.setDataVisitaProduto(leilaoDto.getDataVisitaProduto());
        leilaoExistente.setSiteLeilao(leilaoDto.getSiteLeilao());
        leilaoExistente.setEnderecoFisicoLeilao(leilaoDto.getEnderecoFisicoLeilao());
        leilaoExistente.setCidadeLeilao(leilaoDto.getCidadeLeilao());
        leilaoExistente.setEstadoLeilao(leilaoDto.getEstadoLeilao());
        leilaoExistente.setStatusLeilao(leilaoDto.getStatusLeilao());

        leilaoRepository.atualizarLeilao(leilaoExistente);
        return leilaoExistente.leilaoDto(); 
    }

    @Transactional
    public boolean excluirLeilao(int id) {
        Leilao leilao = leilaoRepository.buscarLeilao(id);
        if (leilao == null) {
            return false;
        }
        leilaoRepository.excluirLeilao(id);
        return true;
    }

    public Leilao buscarLeilaoPorId(int idLeilao) {
        throw new UnsupportedOperationException("Método 'buscarLeilaoPorId' não implementado");
    }
}
