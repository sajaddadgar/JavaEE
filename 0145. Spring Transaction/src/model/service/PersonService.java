package model.service;

import model.entity.Person;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;

@Component

public class PersonService {

    // moadel autowired
    // baraye entitymanager autowired kar dorosti nist bayad az persistenceContext estefade konim
    // va be surat khodkar entitymanager por mishe
    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    public void insert(Person person) {
        entityManager.persist(person);
    }

    // dar select niazi be transactional nist
    public List<Person> getAll(){
        return entityManager.createQuery("select o from Person o").getResultList();
    }

}
