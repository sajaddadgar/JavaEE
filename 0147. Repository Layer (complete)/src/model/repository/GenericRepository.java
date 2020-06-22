package model.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
/*@Transactional*/
public class GenericRepository<T> {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(T t){
        entityManager.persist(t);
    }

    public void update(T t){
        entityManager.merge(t);
    }

    public void delete(long id, Class clazz){
        Object o =
                entityManager.createQuery("select o from " + ((Entity)clazz.getAnnotation(Entity.class)).name()
                + " o where id=:id").setParameter("id", id).getSingleResult();

        entityManager.remove(o);
    }

    public T selectOne(long id, Class clazz){

        Object o =
                entityManager.createQuery("select o from " + ((Entity)clazz.getAnnotation(Entity.class)).name()
                + " o where id=:id").setParameter("id", id).getSingleResult();

        return (T) o;

    }

    public List<T> selectAll(Class clazz){
        return
                entityManager.createQuery("select o from " + ((Entity) clazz.getAnnotation(Entity.class)).name()).getResultList();
    }

}
