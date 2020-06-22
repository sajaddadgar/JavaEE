package amirkabir.model.service;

import amirkabir.model.entity.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class PersonService {


    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insert(Person person){
        entityManager.persist(person);
    }

    @Transactional
    public void update(Person person){
        Person dbPerson = entityManager.find(Person.class, person.getId());
        dbPerson.setName(person.getName());
        dbPerson.setFamily(person.getFamily());
        entityManager.merge(dbPerson);
    }

    @Transactional
    public void delete(Person person){
        person = entityManager.find(Person.class, person.getId());
        entityManager.remove(person);
    }

    public Person selectOne(Person person){
        return entityManager.find(Person.class, person.getId());
    }
    public List<Person> selectAll(){
        return entityManager.createQuery("select o from Person o").getResultList();
    }
}
