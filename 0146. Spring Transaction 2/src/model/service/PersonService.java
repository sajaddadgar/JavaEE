package model.service;

import model.entity.Person;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;

// har kodum ro bezarim
/*@Component*/
@Service
/*@Controller*/
/*@Repository*/

//**** ers bari anotation ha: age ye anotation khodesh ye anotation dashte bashe yani dare az oon ers mibare

public class PersonService {


    @PersistenceContext
    // dar surati ke lazy bood :
    /*@PersistenceContext(type = PersistenceContextType.EXTENDED)*/
    private EntityManager entityManager;

    @Transactional
    public void insert(Person person){
        entityManager.persist(person);
    }

    public List<Person> getAll(){
        return entityManager.createQuery("select o from Person o").getResultList();
    }

}
