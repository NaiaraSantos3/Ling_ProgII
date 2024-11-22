package naiarasantos.com.Service;

import naiarasantos.com.Dto.BancoDto;
import naiarasantos.com.Entity.Banco;
import naiarasantos.com.Repository.BancoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class BancoService {

    @Inject
    BancoRepository bancoRepository;

    @Transactional
    public Banco createBanco(Banco banco) {
        bancoRepository.persist(banco);
        return banco;
    }


    public List<Banco> findAll() {
        return bancoRepository.listAll();
    }

    public Banco findByIdBanco(Integer idBanco) {
        return bancoRepository.findByIdBanco(idBanco);
    }

    @Transactional
    public Banco updateBanco(Banco banco) {
        Banco bancoExistente = bancoRepository.findByIdBanco(banco.getIdBanco());
        if (bancoExistente == null) {
            return null;
        }
        return bancoRepository.merge(banco);
    }

    // Deletar banco
    @Transactional
    public void deleteBanco(Integer idBanco) {
        Banco banco = bancoRepository.findByIdBanco(idBanco);
        if (banco != null) {
            bancoRepository.remove(banco);
        }
    }

    public BancoDto findByCnpj(String cnpj) {
        Banco banco = bancoRepository.findByCnpj(cnpj);
        return banco != null ? banco.bancoDto() : null;
    }
}
