package amirkabir.model.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class GenericRepository<T> {

    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    public void insert(T t){
        entityManager.persist(t);
    }

    @Transactional
    public void update(T t){
        entityManager.merge(t);
    }

    @Transactional
    public void delete(long id, Class clazz){
        Object o = entityManager.find(clazz, id);
        entityManager.remove(o);
    }

    public T selectOne(long id, Class clazz){
        Object o = entityManager.find(clazz, id);
        return (T) o;
    }

    public List<T> selectAll(Class clazz){
        return entityManager.createQuery("select o from " + ((Entity) clazz.getAnnotation(Entity.class)).name()).getResultList();
    }

}
