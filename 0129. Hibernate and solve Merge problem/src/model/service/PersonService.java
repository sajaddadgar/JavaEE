package model.service;

import model.common.ManagerProvider;
import model.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Locale;

public class PersonService {

    public static void main(String[] args) {


        merge();

    }


    public static void merge(){

        EntityManager entityManager = ManagerProvider.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Person dbperson = entityManager.find(Person.class, 1l);
        Person person = new Person();

        person.setId(1);
        person.setName("sajad");
        if (person.getFamily() == null)
            person.setFamily(dbperson.getFamily());
        if (person.getName() == null)
            person.setName(dbperson.getName());

        entityManager.merge(person);

        entityTransaction.commit();
        entityManager.close();

    }

    public static void register(){

        EntityManager entityManager = ManagerProvider.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Person person = new Person();
        person.setName("sajad");
        person.setFamily("dadgar");

        entityManager.persist(person);

        entityTransaction.commit();
        entityManager.close();


    }

}
