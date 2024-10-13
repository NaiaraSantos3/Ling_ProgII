package naiarasantos.com.Service;

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

    public Banco findByIdBanco(int idBanco) {
        return bancoRepository.findByIdBanco(idBanco);
    }

    @Transactional
    public Banco updateBanco(Banco banco) {
        // Primeiro, verificamos se o banco existe
        if (bancoRepository.findByIdBanco(banco.getIdBanco()) == null) {
            return null; // Ou lance uma exceção, dependendo do seu caso de uso
        }
        return bancoRepository.getEntityManager().merge(banco);
    }

    @Transactional
    public void deleteBanco(int idBanco) {
        bancoRepository.deleteByIdBanco(idBanco);
    }

    public Banco findByCnpj(String cnpj) {
        return bancoRepository.findByCnpj(cnpj);
    }
}
