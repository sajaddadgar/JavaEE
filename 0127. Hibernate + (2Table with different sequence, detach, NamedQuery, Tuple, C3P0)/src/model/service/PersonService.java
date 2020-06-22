package model.service;

import model.common.ManagerProvider;
import model.entity.Car;
import model.entity.Person;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.Tuple;
import java.util.List;
import java.util.Locale;

public class PersonService {


    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        halfCatch();
    }


    public static void register(){

        EntityManager entityManager = ManagerProvider.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Person person = new Person();
        person.setName("Sajad");
        entityManager.persist(person);

        Car car = new Car();
        car.setModel("BMW");
        entityManager.persist(car);

        entityTransaction.commit();
        entityManager.close();


    }
    public static void getSingleResult(){

        EntityManager entityManager = ManagerProvider.getEntityManager();
        Query query = entityManager.createNamedQuery("query2");
        query.setParameter("id", 1L);
        Person person = (Person) query.getSingleResult();
        System.out.println(person.getName());
        entityManager.close();

    }
    public static void getAllResult(){

        EntityManager entityManager = ManagerProvider.getEntityManager();

        Query query = entityManager.createNamedQuery("query3");
        List<Person> personList = query.getResultList();
        for (Person person : personList) {
            System.out.println(person.getName());
        }
        entityManager.close();
    }

    // in kar tu 90% mavaghe lazem nist
    // ma mikhahim connection jdbc ke dar JPA ast ra be dast begirad
    // zamani ke mikhahim connection ro bedim be ye bande khodaE
    public static void getConnectionFromJPA(){

        EntityManager entityManager = ManagerProvider.getEntityManager();
        // unwrap -> joda kardan
        // session Hibernate ast
        Session session = entityManager.unwrap(Session.class);
        session.doWork(connection -> System.out.println(connection));
        entityManager.close();

    }

    // detach -> dar update kardan data age persist ham nemizashtim update anjam mishod,
    // vali age ye objecti ro detach konim baad az avaz kardan name, taghir ijad nemishavad
    // be ebarati az did hiberante kharej mikonad
    public static void detach() {
        EntityManager entityManager = ManagerProvider.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Person person = entityManager.find(Person.class, 1L);
        entityManager.detach(person);

        person.setName("kksaaml");
        entityTransaction.commit();
        entityManager.close();
    }


    // tuple
    public static void halfCatch(){

        EntityManager entityManager = ManagerProvider.getEntityManager();
        Query query = entityManager.createQuery("select o.name as x from Person o", Tuple.class);
        List<Tuple> tupleList = query.getResultList();
        for (Tuple tuple : tupleList) {
            System.out.println(tuple.get("x"));
        }
        entityManager.close();
    }

}
