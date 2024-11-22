package naiarasantos.com.Repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import naiarasantos.com.Entity.Banco;
import java.util.List;

@ApplicationScoped
public class BancoRepository {

    @Inject
    EntityManager em;

    // Buscar banco por CNPJ
    public Banco findByCnpj(String cnpj) {
        return em.createQuery("select b from Banco b where b.cnpj = :cnpj", Banco.class)
                .setParameter("cnpj", cnpj)
                .getSingleResult();
    }

    // Buscar banco por ID
    public Banco findByIdBanco(Integer idBanco) {
        return em.createQuery("select b from Banco b where b.idBanco = :idBanco", Banco.class)
                .setParameter("idBanco", idBanco)
                .getSingleResult();
    }

    // Listar todos os bancos
    public List<Banco> listAll() {
        return em.createQuery("select b from Banco b", Banco.class).getResultList();
    }

    // Persistir banco
    public void persist(Banco banco) {
        em.persist(banco);
    }

    // Atualizar banco
    public Banco merge(Banco banco) {
        return em.merge(banco);
    }

    // Remover banco
    public void remove(Banco banco) {
        em.remove(banco);
    }
}
