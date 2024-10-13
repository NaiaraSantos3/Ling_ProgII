package naiarasantos.com.Repository;

import jakarta.enterprise.context.ApplicationScoped;
import naiarasantos.com.Entity.ItemInformatica;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ItemInformaticaRepository {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public void cadastrarItem(ItemInformatica itemInformatica) {
        em.persist(itemInformatica);
    }

    public ItemInformatica buscarItem(int id) {
        return em.find(ItemInformatica.class, id);
    }

    public List<ItemInformatica> listarTodosItens() {
        return em.createQuery("SELECT i FROM ItemInformatica i", 
        ItemInformatica.class).getResultList();
    }

    @Transactional
    public void atualizarItem(ItemInformatica itemInformatica) {
        em.merge(itemInformatica);
    }

    @Transactional
    public void excluirItem(int id) {
        ItemInformatica item = buscarItem(id);
        if (item != null) {
            em.remove(item);
        }
    }
}
